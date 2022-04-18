package com.example.PredefinedIncidentAction;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.PreDefinedIncidentActionDAOService;
import com.model.*;

import org.junit.Assert;
@SpringBootTest
 	class PreDefinedIncident {

	@Autowired
PreDefinedIncidentActionService service;
	
	@Test
	void testAddPreDefinedIncident() {
		PreDefinedIncidentAction action=new PreDefinedIncidentAction ();
		action.setJobDescription("Developer");
		action.setPreDefinedIncidentName("Impact");
		action.setAnyInjuries("Yes");
		action.setJobDescription("Impact on Head");
		service.addPreDefinedIncident(action);
		PreDefinedIncidentAction st=service.findPreDefinedIncident(action.getPIncidentId());
		Assert.assertEquals("Developer", st.getJobDescription());
		Assert.assertEquals("Impact", st.PreDefinedIncidentName());
		Assert.assertEquals("Yes",st.getAnyInjuries());
		Assert.assertEquals("Impact on head", st.getInjuryDescription());
		
		
			}
	
	@Test
	void testPreDefinedIncidentAction() {
			PreDefinedIncidentAction action=new PreDefinedIncidentAction();
		action.setInjuryDescription("Head Fracture");
			try {
				service.addPreDefinedIncident(action);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			PreDefinedIncidentAction action2=service.findAction(action.getPreDefinedIncidentId());
			Assert.assertNull(action2);
			
		}
		
		@Test
		void testFindAllAction() {
			PreDefinedIncidentAction action=new PreDefinedIncidentAction();
			action.setJobDescription("Tester");
			action.setPreDefinedIncidentName("HeadAche");
			action.setAnyInjuries("No");
			action.setJobDescription("Headache");
			service.addPreDefinedIncident(action);
			
			PreDefinedIncidentAction action1=new PreDefinedIncidentAction();
			action1.setJobDescription("Bake");
			action1.setPreDefinedIncidentName("Toothache");
			action1.setAnyInjuries("No");
			action1.setJobDescription("Tooth Pain");
			service.addPreDefinedIncident(action1);
			

			PreDefinedIncidentAction action2=new PreDefinedIncidentAction();
			action2.setJobDescription("Coder");
			action2.setPreDefinedIncidentName("Leg Pain");
			action2.setAnyInjuries("Yes");
			action2.setJobDescription("Fracture");
			service.addPreDefinedIncident(action2);
			
			List<PreDefinedIncidentAction> actionlist=service.findAllPreDefinedIncidentAction();
			actionlist.get(0).getPreDefinedIncidentName();
			Assert.assertEquals(actionlist.get(0).getPreDefinedIncidentName(), "Impact");
			Assert.assertEquals(actionlist.get(1).getPreDefinedIncidentName(), "Neck Pain");
			Assert.assertEquals(actionlist.get(2).getPreDefinedIncidentName(), "Headache");
			Assert.assertEquals(actionlist.get(3).getPreDefinedIncidentName(), "Toothache");
			}
		@Test
		Void testUpdatePreDefinedIncidentAction() {
			PreDefinedIncidentAction action1=new PreDefinedIncidentAction();
			action1.setJobDescription("Analyst");
			action1.setPreDefinedIncidentName("Neck Pain");
			action1.setAnyInjuries("Yes");
			action1.setJobDescription("Scretches");
			service.addPreDefinedIncident(action1);
			action1.setAnyInjuries("No");
			service.updateAction(action1);
			Assert.assertEquals(true, service.updateAction(action1));
		}
		
		@Test
		void testDeleteAction() {
			service.deleteAction(3);
			Object action= service.deleteAction(2);
			Assert.assertNull(action);
				
		}
		}
}
