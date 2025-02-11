/*
 * @author Antonio Fabregat <fabregat@ebi.ac.uk>
 * @author Joe Foster <jfoster@ebi.ac.uk>
 *
 * @date August 2011
 *
 * This Panel contains a grid that is a simple summary of all the direct children of the item in the InfoPanel,
 * it's columns are sortable, filterable and selectable.
 *
 */

Ext.define('lph.browser.content.fascanspecie.SubSpeciesList', {
	/* Begin Definitions */
    extend	    : 'lph.browser.content.generic.GenericList',

    title		: 'Sub Species List',
    region		: 'center',
	frame		: false,
	border		: false,
	features	: [{
		ftype : 'filters',
		local : true
	}],
	
    columns: [
        {
            xtype       : 'actioncolumn',
            width       : 20,
            resizable   : false,
            hideable    : false,
            items       : [{
                getClass : function(v, metadata, record, rowIndex, colIndex, store) {
                    var type = record.get("type");
                    var identified = record.get("identified") ? "list-identified" : "list-unidentified" ;
                    return type + "-" + identified;
                }
            }]
        },
        {header: 'Name',  dataIndex: 'name', flex:1, filter: {type: 'string'}, tooltip: 'LipidomicNet nomenclature name'},
        {header: 'Identified', dataIndex: 'identified', filter: {type: 'boolean'}, tooltip: 'Identified in a paper/external resource', renderer: function(value){return value?"Yes":"No"}},
        {
            xtype       : 'actioncolumn',
            width       : 20,
            resizable   : false,
            hideable    : false,
            sortable    : false,
            items       : [{
                getClass : function(v, metadata, record, rowIndex, colIndex, store) {
                    return "lph-grid-button";
                },
                tooltip : "Go to this lipid...",
                handler : function(grid, rowIndex, colIndex) {
                    var rec = grid.getStore().getAt(rowIndex);
                    grid.fireEvent('itemdblclick', grid, rec, null, null, null);
                }
            }]
        }
    ]
});
