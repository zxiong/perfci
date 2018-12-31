package org.jenkinsci.plugins.perfci.model;

import hudson.ExtensionPoint;
import hudson.FilePath;
import hudson.Launcher;
import hudson.model.*;
import jenkins.model.Jenkins;
import org.jenkinsci.plugins.perfci.common.BaseDirectoryRelocatable;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by Rayson Zhu on 11/17/15.
 */
public abstract class PerformanceTester implements Describable<PerformanceTester>, Serializable, ExtensionPoint {
    public abstract static class PerformanceTesterDescriptor extends
            Descriptor<PerformanceTester> {
    }

    public abstract void run(final Run<?, ?> build, FilePath workspace, final Launcher launcher, final TaskListener listener) throws IOException, InterruptedException;

    public PerformanceTesterDescriptor getDescriptor() {
        return (PerformanceTesterDescriptor) Jenkins.getInstance().getDescriptor(
                this.getClass());
    }
}
