/**
 * @class com.dipforge.IDE.ProjectPanel
 * @extends Ext.panel.Panel
 *
 * Shows a list of available feeds. Also has the ability to add/remove and load feeds.
 *
 * @constructor
 * Create a new Feed Panel
 * @param {Object} config The config object
 */

Ext.define('com.dipforge.IDE.ProjectPanel', {
    extend: 'Ext.panel.Panel',
    
    alias: 'widget.projectpanel',
    
    layout: 'fit',
    title: 'project',
    preventHeader: true,
    
    initComponent: function(){
        Ext.apply(this, {
            items: [
            	Ext.create('Ext.container.Container', {
                   layout: {
                       type: 'anchor'
                   },
            	    items: [this.createProjectView()]
            	})]
        });
        this.addEvents(
            /**
             * @event feedselect Fired when a feed is selected
             * @param {FeedPanel} this
             * @param {String} title The title of the feed
             * @param {String} url The url of the feed
             */
            'feedselect',
            /**
             * @event feedentryshortcutselect Fired when a feed entry short is selected
             * @param {FeedPanel} this
             * @param {String} title The title of the feed
             * @param {String} url The url of the feed
             */
            'feedentryshortcutselect'
        );
        this.callParent(arguments);
    },   
    
    
    /**
     * Create the DataView to be used for the feed list.
     * @private
     * @return {Ext.view.View}
     */
    createProjectView: function(){
        //we want to setup a model and store instead of using dataUrl
    	Ext.define('File', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'file',     type: 'string'},
            {name: 'user',     type: 'string'}
        ]
    	});

    	var store = Ext.create('Ext.data.TreeStore', {
        model: 'File',
        autoLoad: true,
        root: 'root',
        proxy: {
            type: 'ajax',
            //the store will get the content from the .json file
            url: 'files/FileList.groovy'
        }
    	});

    	//Ext.ux.tree.TreeGrid is no longer a Ux. You can simply use a tree.TreePanel
    	this.tree = Ext.create('Ext.tree.Panel', {
        title: 'Core Team Projects',
        anchor: '100% 100%',
        renderTo: Ext.getBody(),
        collapsible: true,
        useArrows: true,
        rootVisible: false,
        store: store,
        multiSelect: true,
        singleExpand: true,
        //the 'columns' property is now 'headers'
        columns: [{
            xtype: 'treecolumn', //this is so we know which column will show the tree
            text: 'File',
            flex: 2,
            sortable: true,
            dataIndex: 'file'
        },{
            text: 'Assigned To',
            flex: 1,
            dataIndex: 'user',
            sortable: true
        }]
    	});
    	return this.tree;
    }   
       
    
 });