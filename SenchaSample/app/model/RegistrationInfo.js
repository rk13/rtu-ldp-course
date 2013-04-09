Ext.define("SenchaSample.model.RegistrationInfo", {
	extend : 'Ext.data.Model',

	config : {
		fields : [ 'name', 'surname', 'email' ]
	},

	send : function() {
		Ext.Msg.alert("Sending ...", 
				'{'+this.get('name')+','+
					this.get('surname')+','+
					this.get('email')+
				'}')
	}
});