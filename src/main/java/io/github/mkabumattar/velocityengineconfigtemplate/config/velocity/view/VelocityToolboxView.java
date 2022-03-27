package io.github.mkabumattar.velocityengineconfigtemplate.config.velocity.view;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

@Deprecated
public class VelocityToolboxView extends VelocityView {
    private String toolboxConfigLocation;

    public void setToolboxConfigLocation(String toolboxConfigLocation) {
        this.toolboxConfigLocation = toolboxConfigLocation;
    }

    protected String getToolboxConfigLocation() {
        return this.toolboxConfigLocation;
    }

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    protected Context createVelocityContext(
            Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        org.apache.velocity.tools.view.context.ChainedContext velocityContext =
                new org.apache.velocity.tools.view.context.ChainedContext(
                        new VelocityContext(model), getVelocityEngine(), request, response, getServletContext());

        if (getToolboxConfigLocation() != null) {
            org.apache.velocity.tools.view.ToolboxManager toolboxManager =
                    org.apache.velocity.tools.view.servlet.ServletToolboxManager.getInstance(
                            getServletContext(), getToolboxConfigLocation());
            Map<String, Object> toolboxContext = toolboxManager.getToolbox(velocityContext);
            velocityContext.setToolbox(toolboxContext);
        }

        return velocityContext;
    }

    @Override
    protected void initTool(Object tool, Context velocityContext) throws Exception {
        // Velocity Tools 1.3: a class-level "init(Object)" method.
        Method initMethod = ClassUtils.getMethodIfAvailable(tool.getClass(), "init", Object.class);
        if (initMethod != null) {
            ReflectionUtils.invokeMethod(initMethod, tool, velocityContext);
        }
    }
}
