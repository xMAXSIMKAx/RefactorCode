package app;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

public class ProductHandler {

    public static void main(String[] args) throws Exception {
        ProductInfo productInfo = new ProductInfo();
        Class<?> infoClass = productInfo.getClass();
        getAnnot(infoClass);
        Method method = infoClass.getMethod("getData");
        getAnnot(method);
    }

    static void getAnnot(AnnotatedElement element) {

        try {

            Annotation[] annotations = element.getAnnotations();

            for (Annotation annotation : annotations) {
                if (annotation instanceof Product) {
                    Product product = (Product) annotation;
                    System.out.printf("Product: %s, quota: %d%n", product.name(), product.quota()
                    );
                }
            }
        } catch (Exception e) {

        }
    }
}
