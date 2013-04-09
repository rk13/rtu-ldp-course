Ext.define("SenchaSample.view.Registration", {
	extend : 'Ext.form.Panel',

	xtype : 'registrationview',

	config : {
		fullscreen : true,
		items : [ {
			xtype : 'fieldset',
			title : 'Registration info',
			items : [ {
						xtype  : 'textfield',
						name   : 'name',
						label  : 'Name'
					  }, {
						 xtype : 'textfield',
						 name  : 'surname',
						 label : 'Surname'
					  }, {
						 xtype : 'emailfield',
						 name  : 'email',
						 label : 'Email'
					  } ]
			}, {
				xtype : 'toolbar',
				layout : {
					pack : 'center'
				},
				items : [ {
						  xtype : 'button',
						  id 	: 'submitregform',
						  text 	: 'Submit'
						}, {
						  xtype : 'button',
						  text 	: 'Clear'
						}, {
						  xtype : 'button',
						  text 	: 'Fill'
						} ]
			} ]
	}

});