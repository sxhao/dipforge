/**
 * @class FeedViewer.FeedViewer
 * @extends Ext.container.Viewport
 *
 * The main FeedViewer application
 * 
 * @constructor
 * Create a new Feed Viewer app
 * @param {Object} config The config object
 */

Ext.define('com.dipforge.IDE.App', {
    extend: 'Ext.container.Viewport',
    border: 0,
    padding: 0,
     
    initComponent: function(){
    	
    	//we want to setup a model and store instead of using dataUrl
    	Ext.define('File', {
            extend: 'Ext.data.Model',
            fields: [
                {name: 'project',     type: 'string'},
                {name: 'file',     type: 'string'},
                {name: 'path',     type: 'string'},
                {name: 'user',     type: 'string'}
            ]
    	});

    	Ext.apply(this, {
            layout: {
                        type: 'border'
                    },
            border: 0,
            padding: 0,
            items: [this.createProjectPanel(),this.createEditorPanel()]
        });
        this.callParent(arguments);
    },
    
    
    /**
     * This method returns the project panel
     */
    createProjectPanel: function() {
    	this.projectPanel = Ext.create('widget.projectpanel', {
            region: 'west',
            collapsible: false,
            width: 250,
            preventHeader: true,
            floatable: false,
            split: false,
            minWidth: 250,
            listeners: {
                scope: this,
                fileselect: this.onFileSelect
            }
        });
        return this.projectPanel;
    },
    
    
    /**
     * Create the editor panel
     * @private
     * @return {com.dipforge.IDE.EditorPanel} feedInfo
     */
    createEditorPanel: function(){
        this.editorpanel = Ext.create('widget.editorpanel', {
            region: 'center',
            minWidth: 300
        });
        return this.editorpanel;
    },
	
	/**
	 * This method is called to handle the on select event
	 */
	onFileSelect: function(panel,fileName,path) {
		this.editorpanel.addEditor(fileName, path,"def bob= 1", "groovy");
		//alert("why now, hello world : " + path);
	}
});