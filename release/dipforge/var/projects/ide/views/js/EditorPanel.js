/**
 * @class FeedViewer.FeedInfo
 * @extends Ext.tab.Panel
 *
 * A container class for showing a series of feed details
 * 
 * @constructor
 * Create a new Feed Info
 * @param {Object} config The config object
 */
Ext.define('com.dipforge.IDE.EditorPanel', {
    
    extend: 'Ext.tab.Panel',
    alias: 'widget.editorpanel',
    tabPosition: 'bottom',
    
    maxTabWidth: 230,
    border: false,
    plugins: [{
                ptype: 'tabscrollermenu',
                maxText  : 15,
                pageSize : 5
            }],

    initComponent: function() {
        this.tabBar = {
            border: true
        };
        this.callParent(arguments);
    },
    
    // template method
    afterRender: function(){
        this.callParent(arguments);
    },
    
    /**
     * Add a new feed
     * @param {String} title The title of the feed
     * @param {String} url The url of the feed
     */
    addEditor: function(fileName, path,content, mode){
        var active = this.getComponent(path);
        if (!active) {
            active = this.add(Ext.create('Ext.panel.Panel', {
                layout: "fit",
                html: '<div id="id|' + path + '" style="height: 100%; width: 100%">var test = 1</div>',
                itemId: path,
                id: path,
                title: fileName,
                url: path,
                closable: true,
                width: '100%',
                height: '100%'
            }));
            this.setActiveTab(active);
        
            var el = Ext.get("id|" + path)
            var editor = ace.edit(el.dom);
            var JavaScriptMode = require("ace/mode/" + mode).Mode;
            editor.getSession().setMode(new JavaScriptMode());
            editor.resize();
            
        } else {
            this.setActiveTab(active);
        }
    }
});