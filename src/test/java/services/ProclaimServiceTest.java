
package services;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import utilities.AbstractTest;
import domain.Category;
import domain.Proclaim;
import domain.StudentCard;
import domain.Ticker;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/junit.xml"
})
@Transactional
public class ProclaimServiceTest extends AbstractTest {

	@Autowired
	private ProclaimService	service;


	/**
	 * TEST 1
	 * Requirement tested:
	 * Members only can delete their proclaims.
	 * 
	 * 
	 * TEST 2
	 * Requirement tested:
	 * Every proclaim must store a ticker, a title, a description, the moment when it is created, and some attachments.
	 * 
	 * 
	 * TEST 3
	 * Requirement tested:
	 * Every member can self-assign any proclaim that is not attended on the system.
	 * 
	 * 
	 * TEST 4
	 * Requirement tested:
	 * A student can closer their proclaims.
	 * 
	 * 
	 * TEST 5
	 * Requirement tested:
	 * Students can publish proclaims.
	 * 
	 * 
	 * - Analysis of sentence coverage of ProclaimService: 45.8%
	 * 
	 * Total instructions: 633; Covered Instructions: 290
	 * 
	 * - Analysis of data coverage: 68.3%
	 * 
	 * Attribute: title| Bad value: - | Normal value: Yes | Coverage: 50% |
	 * Attribute: description| Bad value: - | Normal value: Yes | Coverage: 50% |
	 * Attribute: finalMode| Bad value: false | Normal value: true | Coverage: 100% |
	 * Attribute: moment| Bad value: - | Normal value: Yes | Coverage: 100% |
	 * Attribute: attachments| Bad value: - | Normal value: Yes | Coverage: 50% |
	 * Attribute: status| Bad value: - | Normal value: Yes | Coverage: 33% |
	 * Attribute: law| Bad value: - | Normal value: Yes | Coverage: 100% |
	 * Attribute: reason| Bad value: - | Normal value: true | Coverage: 100% |
	 * Attribute: closed| Bad value: - | Normal value: Yes | Coverage: 50% |
	 * Attribute: category| Bad value: - | Normal value: Yes | Coverage: 50% |
	 * 
	 * 
	 */

	@Test
	public void test1() {
		final Object[][] objects = {
			{	// Delete his proclaim- Positive Case
				"student1", "proclaim2", null
			}, {
				// Delete other proclaim - Negative Case
				"student1", "proclaim1", IllegalArgumentException.class
			}
		};
		for (int i = 0; i < objects.length; i++) {
			System.out.println(i);
			this.template((String) objects[i][0], super.getEntityId((String) objects[i][1]), (Class<?>) objects[i][2]);
		}
	}

	protected void template(final String username, final int id, final Class<?> expected) {
		Class<?> caught = null;
		try {
			this.authenticate(username);
			this.service.delete(id);

			super.unauthenticate();
		} catch (final Throwable oops) {
			caught = oops.getClass();
		}
		super.checkExceptions(expected, caught);
	}

	@Test
	public void test2() {
		final Object[][] objects = {
			{	// Simple edit - Positive Case
				"student1", "proclaim2", "proclaimEditada", null
			}, {
				// Simple edit with an empty attribute - Negative Case
				"student1", "proclaim2", "", ConstraintViolationException.class
			}
		};
		for (int i = 0; i < objects.length; i++) {
			System.out.println(i);
			this.template2((String) objects[i][0], super.getEntityId((String) objects[i][1]), (String) objects[i][2], (Class<?>) objects[i][3]);
		}
	}

	protected void template2(final String username, final int id, final String cadena, final Class<?> expected) {
		Class<?> caught = null;
		try {
			this.authenticate(username);
			Proclaim p;
			p = this.service.findOne(id);
			p.setDescription(cadena);
			this.service.save(p);
			this.service.flush();

			super.unauthenticate();
		} catch (final Throwable oops) {
			caught = oops.getClass();
		}
		super.checkExceptions(expected, caught);
	}

	@Test
	public void test3() {
		final Object[][] objects = {
			{	//A member is assigned a proclaim that he did not have assigned. - Positive Case
				"member1", "proclaim5", null
			}, {
				// A member is assigned a proclaim that had already been assigned - Negative Case
				"member1", "proclaim1", IllegalArgumentException.class

			}
		};
		for (int i = 0; i < objects.length; i++) {
			System.out.println(i);
			this.template3((String) objects[i][0], super.getEntityId((String) objects[i][1]), (Class<?>) objects[i][2]);
		}
	}

	protected void template3(final String username, final int id, final Class<?> expected) {
		Class<?> caught = null;
		try {
			this.authenticate(username);

			this.service.assign(id);

			super.unauthenticate();
		} catch (final Throwable oops) {
			caught = oops.getClass();
		}
		super.checkExceptions(expected, caught);
	}

	@Test
	public void test4() {
		final Object[][] objects = {
			{	// close his proclaim - Positive Case
				"student1", "proclaim2", null
			}, {
				//A student cancels a proclaim that is not his - Negative Case
				"student2", "proclaim2", IllegalArgumentException.class

			}
		};
		for (int i = 0; i < objects.length; i++) {
			System.out.println(i);
			this.template4((String) objects[i][0], super.getEntityId((String) objects[i][1]), (Class<?>) objects[i][2]);
		}
	}

	protected void template4(final String username, final int id, final Class<?> expected) {
		Class<?> caught = null;
		try {
			this.authenticate(username);

			Proclaim proclaim;
			proclaim = this.service.findOne(id);

			proclaim.setClosed(true);

			super.unauthenticate();
		} catch (final Throwable oops) {
			caught = oops.getClass();
		}
		super.checkExceptions(expected, caught);
	}

	@Test
	public void test5() {
		final Object[][] objects = {
			{	// Simple creation - Positive Case
				"student1", "proclaim2", null
			}, { // A sponsor create a proclaim
				"sponsor1", "proclaim2", IllegalArgumentException.class
			}
		};
		for (int i = 0; i < objects.length; i++) {
			System.out.println(i);
			this.template5((String) objects[i][0], super.getEntityId((String) objects[i][1]), (Class<?>) objects[i][2]);
		}
	}
	protected void template5(final String username, final int id, final Class<?> expected) {
		Class<?> caught = null;
		try {
			this.authenticate(username);
			Proclaim proclaim;
			proclaim = this.service.create();

			Category categoria;
			categoria = this.service.findOne(id).getCategory();

			this.service.create();
			proclaim.setCategory(categoria);

			proclaim.setDescription("Hola");

			proclaim.setLaw("hola");

			proclaim.setReason("hola");
			proclaim.setTitle("hola");

			proclaim.setAttachments("http://us.es");

			StudentCard studentCard;
			studentCard = new StudentCard();
			studentCard.setCentre("ETSII");
			studentCard.setCode(1434);
			studentCard.setVat("47338340Q");

			proclaim.setStudentCard(studentCard);

			proclaim.setTicker(new Ticker());

			this.service.save(proclaim);
			this.service.flush();
			super.unauthenticate();

		} catch (final Throwable oops) {
			caught = oops.getClass();
		}
		super.checkExceptions(expected, caught);
	}

}
