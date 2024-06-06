package helpers;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.Arrays;

@Provider
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println(requestContext.getHeaders()+"\n");
        System.out.println(requestContext.getUriInfo().getAbsolutePath());
    }

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("\n"+responseContext.getHeaders()+"\n");
        System.out.println(Arrays.toString(responseContext.getEntityAnnotations())+"\n");
        System.out.println(requestContext.getEntityStream()+"\n");
        requestContext.getHeaders().add("Loggin","info");
    }
}