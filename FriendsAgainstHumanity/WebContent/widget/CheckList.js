//define(["dojo/_base/declare",  "dijit/_WidgetBase",  "dijit/_TemplatedMixin", "dojo/text"], 
//function(declare, _WidgetBase, _TemplatedMixin) {
//	return declare([_WidgetBase, _TemplatedMixin], {
//		store: null,
//		query: null,
//		queryOptions: null,
//		fetchText: '...',
//		postCreate: function(){
//			// TODO: Generate UI Elements
//		}
//	});
//});

define([
	"dojo/_base/declare",
	"dijit/_WidgetBase",
	"dijit/_TemplatedMixin",
	"dojo/text!./CheckList/template.html"
], 
function(declare, _WidgetBase, _TemplatedMixin, template) {
	
	return declare("CheckList", [_WidgetBase, _TemplatedMixin ], {
		
            templateString: template,
            constructor: function(store) {
            	this.store = store;
            	refresh();
            },
            info: null,
            refresh: function() {
            	alert("Refresh");
            }
	});
     
});