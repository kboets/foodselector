(function($) {
 
	$.widget("ui.progressbarFS",  {
		
		// Default options.
	    options: {
	        value: 0,
	        htmlId :"",
	        color :"#D2572E"
	    },		
		
		_create: function() {
	        var progress = this.options.value + "%";	        	   
	        var progressbar = jQuery('#'+this.options.htmlId);
	        var progressbarLabelId =this.options.htmlId+"Label";
	        var styleElements = [ "width:"+progress+";background-color:"+this.options.color];	        
	        var style = "width:"+progress;
	        this.element.addClass( "agfProgressbar" );        
	        this.valueDiv = $( "<div class='agfProgressbar agfProgressbarLabel agfProgressbarText'></div>" )	        	
	        	.appendTo( this.element )
	        	.attr({
	        		"style": styleElements,
	        		"id" : progressbarLabelId
	        	}).text(progress);	             
	            
	    },
	    
	    value: function( value ) {
	    	//no value passed, act as a getter
	    	if ( value === undefined ) {
	    		return this.options.value;
	    	}
	    	this.options.value = this._constrain( value );	    	
	    	alert(this.options.value);
	    	this.refresh();
	    },
	    
	    _setOption: function( key, value ) {
	        if ( key === "value" ) {
	            value = this._constrain( value );
	        }
	        this._super( key, value );	        
	    },
	    
	    _setOptions: function( options ) {
	        this._super( options );
	        this.refresh();
	    },
	    
	    refresh: function() {    	
	    	var value = this._constrain(this.options.value);    	
	    	var progress = value + "%";	    	
	    	var styleElements = [ "width:"+value+"%;background-color:"+this.options.color];	    	
	    	var progressbarLabelId = this.options.htmlId+"Label";
	    	var progressbarLabel = jQuery('#'+progressbarLabelId);
	    	progressbarLabel.removeAttr("style");
	    	progressbarLabel.attr({
	    		"style": styleElements
	    		})
	    		.text(progress);
	    	if ( value === 100 ) {
	    		progressbarLabel.text("Completed !")
	    		this.destroy();
	    	}   	   	
	    },
	    
	    update : function(value) {
	    	value = this._constrain(value);
	    	var progress = value + "%";	    	
	    	var styleElements = [ "width:"+value+"%;background-color:"+this.options.color];	    	
	    	var progressbarLabelId = this.options.htmlId+"Label";
	    	var progressbarLabel = jQuery('#'+progressbarLabelId);
	    	progressbarLabel.removeAttr("style");
	    	progressbarLabel.attr({
	    		"style": styleElements
	    		})
	    		.text(progress);
	    	if ( value === 100 ) {
	    		progressbarLabel.text("Completed !")
	    		this.destroy();
	    	}  	
	    	
	    },
	    
	    updateTimeOut : function(value) {
	    	setTimeout(function(){
	    		value = this._constrain(value);
		    	var progress = value + "%";	    	
		    	var styleElements = [ "width:"+value+"%;background-color:"+this.options.color];	    	
		    	var progressbarLabelId = this.options.htmlId+"Label";
		    	var progressbarLabel = jQuery('#'+progressbarLabelId);
		    	progressbarLabel.removeAttr("style");
		    	progressbarLabel.attr({
		    		"style": styleElements
		    		})
		    		.text(progress);
		    	if ( value === 100 ) {
		    		progressbarLabel.text("Completed !")
		    		var progressbar = jQuery('#myProgressbar');
		    		var progressbarLabel = jQuery('#progressbarLabel');
		    		progressbarLabel.removeClass("agfProgressbar agfProgressbarLabel agfProgressbarText").text("");	    		
		    		progressbar.removeClass( "agfProgressbar" )	 
		    	}	
	    	}, 500);
	    	  	
	    	
	    },
	    _constrain: function( value ) {
	    	if ( value > 100 ) {
	            value = 100;
	        }
	    	if ( value < 0 ) {
	            value = 0;
	        }
	    	return value;
	    },  
	    
	    destroy: function() {    	
	    	setTimeout(function () { 
	    		var progressbar = jQuery('#myProgressbar');
	    		var progressbarLabel = jQuery('#progressbarLabel');
	    		progressbarLabel.removeClass("agfProgressbar agfProgressbarLabel agfProgressbarText").text("");	    		
	    		progressbar.removeClass( "agfProgressbar" )	    		
	    	}, 1000);	
	    	
	    	jQuery.Widget.prototype.destroy.call(this);
	    }
	});
	
	
})(jQuery);





