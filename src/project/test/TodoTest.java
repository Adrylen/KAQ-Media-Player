/**
 * Java Project
 * Project
 * Package : project.test
 * Created by adrylen on 26/03/17.
 */
package project.test;

import project.todo.Importance;
import project.todo.Todo;

@Todo(
	importance = Importance.NONE,
	assignedTo = "Adrien",
	description = "Cette classe présente comment récupérer les annotations"
)
public class TodoTest {
	public static void main(String[] args) {
		Class classe = TodoTest.class;
		Todo todo = (Todo) classe.getAnnotation(Todo.class);
		System.out.println(classe.getName());
		if (todo != null) {
			System.out.println("["+todo.importance()+"]");
			System.out.println(todo.assignedTo()+" : "+todo.description());
		}
	}
}
