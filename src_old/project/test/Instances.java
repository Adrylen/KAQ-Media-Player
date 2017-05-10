/*
 *   Java Project
 *   Project
 *   Package : project.test
 *   Created by AdrienMartinez on 09/05/2017.
*/

package project.test;

public class Instances {
	public static void main(String[] args) {
		TestInstance.getInstance();
		System.out.println(TestInstance.getInstance().a);

		TestInstance.getInstance().incr();
		System.out.println(TestInstance.getInstance().a);
		TestInstance.getInstance().incr();
		System.out.println(TestInstance.getInstance().a);
		TestInstance.getInstance().incr();
		System.out.println(TestInstance.getInstance().a);
	}
}
