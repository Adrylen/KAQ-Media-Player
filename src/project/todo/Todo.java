/**
 * Java Project
 * Project
 * Package : project.todo.annotation
 * Created by adrylen on 26/03/17.
 */
package project.todo;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Todo {
	Importance importance() default Importance.MINOR;
	String assignedTo();
	String description();
}
