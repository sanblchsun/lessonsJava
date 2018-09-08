
package mysort;

import java.lang.annotation.ElementType;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value=ElementType.TYPE)

public @interface Developer {
    String fname();
    String lname();
    String data();
    String vertion() default "0.1";
}
