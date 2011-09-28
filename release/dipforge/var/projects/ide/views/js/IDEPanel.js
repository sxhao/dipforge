/**
 * @class IDEPanel.IDEPanel
 * @extends Ext.panel.Panel
 *
 * Shows a list of available feeds. Also has the ability to add/remove and load feeds.
 *
 * @constructor
 * Create a new Feed Panel
 * @param {Object} config The config object
 */

Ext.define('com.dipforge.IDE.IDEPanel', {
    extend: 'Ext.panel.Panel',

    alias: 'widget.idepanel',
    preventHeader: true,
    layout: 'fit',
    tbar: [{
             iconCls: 'add16',
             text: 'Button 1'
         },
         '-',
         {
             iconCls: 'add16',
             text: 'Button 2'
         },{
             iconCls: 'add16'
         },{
             iconCls: 'add16'
         },
         '-',
         {
             iconCls: 'add16'
         }
     ],
   
   /**
    * Init the components
    */
   initComponent: function(){
    	  Ext.apply(this, {
      items: [
         Ext.create('Ext.container.Container', {
            layout: {
               type: 'border'
               },
               border: 0,
               items: [this.createProjectPanel(),this.createEditorPanel()]
         })]
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
            floatable: false,
            split: false,
            minWidth: 250//,
            //listeners: {
            //    scope: this,
            //    feedselect: this.onFeedSelect
            //}
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
    }
   
});