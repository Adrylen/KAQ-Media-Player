/*
 *   Java Project
 *   Project
 *   Package : project.test
 *   Created by AdrienMartinez on 09/05/2017.
*/

package project.test;

class TestInstance {
	public static TestInstance instance = null;

	public int a;

	public static TestInstance getInstance() {
		if(instance == null) {
			instance = new TestInstance();
		}
		return instance;
	}

	public TestInstance() {
		this.a = 0;
	}

	public void incr() {
		this.a++;
	}
}