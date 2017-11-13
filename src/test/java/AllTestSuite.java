/*
 * Copyright (c) 2017 by Benjamin Stone
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.wahlzeit.handlers.HandlersTestSuite;
import org.wahlzeit.model.ModelTestSuite;
import org.wahlzeit.model.persistence.PersistanceTestSuite;
import org.wahlzeit.services.ServicesTestSuite;
import org.wahlzeit.services.mailing.ServiceMailingTestSuite;
import org.wahlzeit.testEnvironmentProvider.TestEnvironmnentTestSuite;
import org.wahlzeit.utils.UtilityTestSuite;



@RunWith(Suite.class)


@SuiteClasses({
	
	HandlersTestSuite.class,
	ModelTestSuite.class, 
	//PersistanceTestSuite.class, 
	ServicesTestSuite.class, 
	ServiceMailingTestSuite.class, 
	//TestEnvironmnentTestSuite.class,
	UtilityTestSuite.class
})


/**
 * Overall Wahlzeit Root Test Suite. Includes every Testsuite on lower Packages. 
 */
public class AllTestSuite{ }
