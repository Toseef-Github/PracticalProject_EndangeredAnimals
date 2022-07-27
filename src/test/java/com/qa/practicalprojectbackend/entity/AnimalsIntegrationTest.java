package com.qa.practicalprojectbackend.entity;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

public class AnimalsIntegrationTest {
	
	     @Test
	        public void testEquals() {
	            EqualsVerifier.simple().forClass(Animals.class).verify();
	        }
	}
