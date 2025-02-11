Ext.define('lph.tools.searchengine.output.OutputPane', {
	/* Begin Definitions */
    extend	: 'Ext.Panel',
    
    title	: 'Output',
    iconCls : 'data-output-16',
    layout	: 'border',
    disabled: true,

    constructor: function(config) {
    	this.callParent(arguments);
        this.initConfig(config);

        this.addEvents({
           load         : true,
           error        : true,
           itemSelected : true
        });

        this.mask = new Ext.LoadMask(this, {msg:"Applying selected filter, please wait..."});

        var store = Ext.create('Ext.data.TreeStore', {
            fields  : [
                {name: 'itemId',  type : 'int'},
                {name: 'code',  type : 'string'},
                {name: 'type',  type : 'string'}//, defaultValue: 'category'}
            ]
		});
        this.hierarchy = Ext.create('lph.tools.searchengine.output.SelectionHierarchyPanel',{
            region	: 'west',
            width	: 300,
            store   : store
        });
        //this.hierarchy.getChecked();
        this.add(this.hierarchy);

        var groupingFeature = Ext.create('Ext.grid.feature.Grouping',{
            enableGroupingMenu  : false,
            groupHeaderTpl      : 'Mass: {name} ({rows.length} Item{[values.rows.length > 1 ? "s" : ""]})'
        })

        this.resultGrid = Ext.create('lph.tools.searchengine.output.ResultGrid',{
            region	    : 'center',
            store       : this._getStore(),
            hierarchy   : this.hierarchy,
            features	: [
                groupingFeature,
                {
                    ftype : 'filters',
                    local : true
                }
            ],
        });
        this.add(this.resultGrid);

        this.bind();

        return this;
    },

    bind: function(){
        this.hierarchy.addListener('beforeFilterChange', this._mask, this);

        this.hierarchy.addListener('filterChange', this.resultGrid.filter, this.resultGrid);
        this.hierarchy.addListener('afterFilterChange', this._unmask, this);
    },

    executeQuery : function(params){
        Ext.Ajax.request({
            method  : 'POST',
            url     : 'service/tools/ms1search',
            params  : params,
            success : this.onSuccess,
            failure : this.onFailure,
            scope   : this
        });
    },

    onSuccess: function(res, opts){
        var res = Ext.decode(res.responseText);
        Ext.each(res.list, function(item){
            item.delta = Ext.util.Format.round(item.mass - item.resMass, 5);
        })
        if(this.fireEvent('beforeload')!==false){
            this.resultGrid._refresh();
            //this.resultGrid.getStore().removeAll(true);
            this.resultGrid.getStore().loadRawData(res);
            this.fireEvent('load');
        }

    },

    onFailure: function(res, opts){
        var res = Ext.decode(res.responseText);
        this.fireEvent('error', res);
    },

    _getStore: function(id){
    	var store = Ext.create('Ext.data.Store', {
		    model       : 'MS1SearchEngineResultModel',
            groupField  : 'mass'
		});
        return store;
    },

    _mask: function(){
        if(!Ext.isEmpty(this.mask)) this.mask.show();
    },

    _unmask: function(){
        if(!Ext.isEmpty(this.mask)) this.mask.hide();
    }
});

Ext.define('MS1SearchEngineResultModel', {
    extend: 'Ext.data.Model',
    //url : '',
    fields: [
        { name: 'itemId', type: 'int' },
        { name: 'name', type: 'string' },
        { name: 'mass', type: 'float' },
        { name: 'identified', type: 'boolean' },
        { name: 'faCarbons', type: 'int' },
        { name: 'faDoubleBonds', type: 'int' },
        { name: 'resMass', type: 'float' },
        { name: 'adductIon', type: 'string' },
        { name: 'delta', type: 'float'},
        { name: 'code', type: 'string' },
        { name: 'type', type: 'string' }
    ],
    proxy: {
        type: 'ajax',
        reader: {
            type: 'json',
            root: 'list'
        }
    }
});