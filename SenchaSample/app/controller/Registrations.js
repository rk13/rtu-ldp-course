Ext.define("SenchaSample.controller.Registrations", {
	extend : 'Ext.app.Controller',

	config : {
		refs : {
			regform : 'registrationview',
			submitRegform : '#submitregform'
		},

		control : {
			submitRegform : {
				tap : function() {
					var reginfo = 
						Ext.create('SenchaSample.model.RegistrationInfo', 
								this.getRegform().getValues());

					reginfo.send();
				}
			}
		}
	}
});