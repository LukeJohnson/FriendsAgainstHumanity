define(["dojo/_base/declare","dijit/_WidgetBase", "dijit/_TemplatedMixin", "dojo/dom-construct"],
    function(declare, _WidgetBase, _TemplatedMixin, domConstruct){
        return declare([_WidgetBase, _TemplatedMixin], {
        	constructor: function(deck) {
             	this.deck = deck;
             },

             buildRendering: function(){
                 // create the DOM for this widget
            	 
            	 var card = domConstruct.create("div");
     			card.className = "deck";

     			var cardText =  domConstruct.create("div");
     			cardText.className = "cardText";
     			cardText.innerHTML = this.deck.name;
     			
     			var footer =  domConstruct.create("div");
     			footer.className = "cardFooter";
     			footer.innerHTML = "<img src='/FriendsAgainstHumanity/img/cardLogo.png' /> " + this.deck.id;
     			
     			card.appendChild(cardText);
     			card.appendChild(footer);
            	 
                 this.domNode = card;
             },
             postCreate: function(){
	                //this.connect(this.domNode, "onclick", "doSomething");
	         },
	         doSomething: function() {
	        	 alert("boo");
	         }
             
        });
}); 
