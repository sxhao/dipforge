/*
 * CoadunationTypeManagerConsole: The type management console.
 * Copyright (C) 2009  Rift IT Contracting
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 *
 * AtomicPanel.java
 */

package com.rift.coad.change.client.tree;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.rift.coad.audit.gwt.console.client.query.Factory;
import com.rift.coad.change.client.action.ActionsCache;
import com.rift.coad.change.client.action.ActionsFactory;
import com.rift.coad.change.client.action.workflow.WorkflowFactory;
import com.rift.coad.change.client.action.workflow.WorkflowMenu;
import com.rift.coad.change.client.resources.QueryConnector;
import com.rift.coad.gwt.lib.client.console.NavigationDataCallback;
import com.rift.coad.gwt.lib.client.console.NavigationDataHandler;
import com.rift.coad.gwt.lib.client.console.NavigationTreeNode;
import com.rift.coad.rdf.objmapping.client.resource.ResourceBase;
import com.rift.coad.rdf.objmapping.util.client.type.TypeManager;
//import com.rift.coad.type.manager.client.ManageResourcesUtil;
//import com.rift.coad.type.manager.client.type.factory.ResourceCreationFactory;
//import com.rift.coad.type.manager.client.type.factory.ResourceFactory;
import com.smartgwt.client.util.SC;
import java.util.List;

/**
 * The resource data handler is responsible for getting the resource together.
 *
 * @author brett chaldecott
 */
public class ResourceDataHandler implements NavigationDataHandler {


    /**
     * This
     */
    public class HandleResourceList  implements AsyncCallback {

        private NavigationDataCallback callback;
        private String parent;

        /**
         * This constructor is responsible for setting the callback object.
         * @param callback
         */
        public HandleResourceList(NavigationDataCallback callback, String parent) {
            this.callback = callback;
            this.parent = parent;
        }


        /**
         * This method is called to handle exceptions.
         *
         * @param caught The caught exception.
         */
        public void onFailure(Throwable caught) {
            SC.say("Failed to retrieve the resource list : " + caught.getMessage());
        }


        /**
         * This method is called on success.
         *
         * @param result The results.
         */
        public void onSuccess(Object result) {
            try {
                List<ResourceBase> types = (List<ResourceBase>)result;
                NavigationTreeNode[] nodes = new NavigationTreeNode[types.size()];
                for (int count = 0; count < types.size(); count++) {
                    ResourceBase type = types.get(count);
                    nodes[count] = new NavigationTreeNode(type.getIdForDataType(),
                            "DataType:" + type.getIdForDataType(), parent, com.rift.coad.rdf.objmapping.ui.client.tree.type.TypeManager.getIcon(type.getBasicType()),
                                            null, true, "",true);
                }
                callback.addChildren(nodes);
            } catch (Exception ex) {
            SC.say("Failed to set the node information : " + ex.getMessage());
            }
        }

    }


    /**
     * The default constructor.
     */
    public ResourceDataHandler() {
    }
    
    /**
     * This method gets the child nodes
     * 
     * @param name
     * @param callback
     */
    public void getChildNodes(String name, NavigationDataCallback callback) {
        try {
            if (name.equals("root")) {
                callback.addChildren(new NavigationTreeNode[] {
                            new NavigationTreeNode("Development", "development", "root", "applications-development.png", null, true, "",true),
                            new NavigationTreeNode("Management", "management", "root", "preferences-system.png", null, true, "",true),
                            new NavigationTreeNode("Audit Trail", "audittrail", "root", "media-record.png",
                                    new Factory("","com.rift.coad.change.ChangeManagerDaemonImpl"), true, "",false)});
            } else if (name.equals("development")) {
                callback.addChildren(new NavigationTreeNode[] {
                            new NavigationTreeNode("Organisation", "organisation", "development", "system-users.png",
                                    null, true, "",true),
                            new NavigationTreeNode("Person", "person", "development", "contact-new.png",
                                    null, true, "",true),
                            new NavigationTreeNode("Inventory", "inventory", "development", "folder.png",
                                    null, true, "",true),
                            new NavigationTreeNode("Service", "service", "development", "network-workgroup.png",
                                    null, true, "",true),
                            new NavigationTreeNode("Misc", "misc", "development", "package-x-generic.png",
                                    null, true, "", true)});
            } else if (name.equals("management")) {
                callback.addChildren(new NavigationTreeNode[] {
                            new NavigationTreeNode("Actions", "actions", "actions", "applications-system.png", new ActionsFactory(), true, "",false)});
            } else if (name.contains("DataType:")) {
                addActions(name,callback);
            } else {
                QueryConnector.getService().listTypes(TypeManager.getTypesForGroup(name),new HandleResourceList(callback,name));
            }
        } catch (Exception ex) {
            SC.say("Failed to render tree changes : " + ex.getMessage());
        }
    }


    /**
     * This method adds the tree nodes.
     *
     * @param name The name of the tree node.
     */
    private void addActions(String name,NavigationDataCallback callback) {
        List<String> actions = ActionsCache.getInstance().getActions();
        NavigationTreeNode[] nodes = new NavigationTreeNode[actions.size()];
        String parsedName = name.replace("DataType:", "");
        for (int index = 0; index < actions.size(); index++) {
            String action  = actions.get(index);
            WorkflowFactory factory = new WorkflowFactory(action,parsedName);
            factory.create();
            nodes[index] = new NavigationTreeNode(action, action + ":" + parsedName, name, "workflow.png",
                                    factory, true, "",false,new WorkflowMenu(factory.getPanel()));
        }
        callback.addChildren(nodes);

    }

}
