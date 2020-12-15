package group03.project.design;

import org.junit.jupiter.api.Test;

import com.structurizr.Workspace;
import com.structurizr.analysis.ComponentFinder;
import com.structurizr.analysis.ReferencedTypesSupportingTypesStrategy;
import com.structurizr.analysis.SpringComponentFinderStrategy;
import com.structurizr.model.*;
import com.structurizr.view.*;

public class GenerateModel {

    @Test
    public void generateModel() throws Exception {

        // Workspace set up and attached to base model.
        Workspace workspace = new Workspace("Development Reflection Toolkit",
                "Spring Boot project for Group 3's implementation of the Development Reflection Toolkit");
        Model model = workspace.getModel();

        // Basic model creation
        SoftwareSystem reflectionToolkit = model.addSoftwareSystem("ReflectionToolkit", "Activity reflection system for lecturers");
        // Categories of people that use model.
        Person siteUser = model.addPerson("Site User", "A person who adds reflections onto provided & custom activities of their learning journey");
        Person admin = model.addPerson("Administrator", "A person who can add official activities onto system, along with view of average datasets");
        siteUser.uses(reflectionToolkit, "Uses");
        admin.uses(reflectionToolkit, "Uses");

        // Broad containers to cover the base levels of Model.
        Container webApp = reflectionToolkit.addContainer
                ("Spring Boot Application", "Toolkit web application", "Embedded web container. Tomcat 7.0");
        Container toolKitRDatabase = reflectionToolkit.addContainer
                ("toolKitDatabase", "Relational database that stores data relating to users, activities and participation records", "MySQL");

        //Confirmation of usage by both categories, along with webApp container.
        siteUser.uses(webApp, "Uses", "HTTP");
        admin.uses(webApp, "Uses", "HTTP");
        webApp.uses(toolKitRDatabase, "Reads and writes data to Relational database", "JPA, port 3306");

        ComponentFinder componentFinder = new ComponentFinder(
                webApp,
                "group03.project",
                new SpringComponentFinderStrategy(
                        new ReferencedTypesSupportingTypesStrategy()
                ));

        componentFinder.findComponents();

        // connects the siteUser Person to all mvc controller that they use.
        webApp.getComponents().stream()
                .filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(tech -> siteUser.uses(tech, "Uses", "HTTP"));
        // connects the siteUser Person to all mvc controller that they use.
        webApp.getComponents().stream()
                .filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER))
                .forEach(tech -> admin.uses(tech, "Uses", "HTTP"));
        // connects all repository component to toolKitDatabase.
        webApp.getComponents().stream()
                .filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY))
                .forEach(tech -> tech.uses(toolKitRDatabase, "Reads and writes data to Relational database", "JPA"));

        // Testing for existence of components as proof of working.
        for (Component component : webApp.getComponents()) {
            System.out.println(component.getRelationships());
        }


        Component siteUserService = webApp.getComponentOfType("group03.project.services.SiteUserService");
        Component siteUserRepo = webApp.getComponentOfType("group03.project.repositories.SiteUserRepoJPA");
        siteUserService.uses(siteUserRepo, "uses");

        ViewSet viewSet = workspace.getViews();
        SystemContextView contextView = viewSet.createSystemContextView(reflectionToolkit, "context", "System context diagram for the Reflection Toolkit system.");
        contextView.addAllSoftwareSystems();
        contextView.addAllPeople();

        ContainerView containerView = viewSet.createContainerView(reflectionToolkit, "containers", "Containers diagram for the Reflection Toolkit system.");
        containerView.addAllSoftwareSystems();
        containerView.addAllPeople();
        containerView.addAllContainers();

        ComponentView componentView = viewSet.createComponentView(webApp, "components", "The Components diagram for the Reflection Toolkit web application.");
        componentView.addAllComponents();
        componentView.addAllPeople();
        componentView.add(toolKitRDatabase);

        // Link model with the code within gitlab.
        for (Component component : webApp.getComponents()) {
            for (CodeElement codeElement : component.getCode()) {
                String srcPath = codeElement.getUrl();
                if (srcPath != null) {
                    codeElement.setUrl("https://git.cardiff.ac.uk/c1936922/group-03-staff-project/-/tree/master");
                }
            }
        }

        toolKitRDatabase.setUrl("https://git.cardiff.ac.uk/c1936922/group-03-staff-project/-/tree/master/src/main/resources");

        reflectionToolkit.addTags("Reflection Toolkit");
        webApp.getComponents().stream().filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(component -> component.addTags("Spring MVC Controller"));
        webApp.getComponents().stream().filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_MVC_CONTROLLER)).forEach(component -> component.addTags("Spring REST Controller"));

        webApp.getComponents().stream().filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_SERVICE)).forEach(component -> component.addTags("Spring Service"));
        webApp.getComponents().stream().filter(tech -> tech.getTechnology().equals(SpringComponentFinderStrategy.SPRING_REPOSITORY)).forEach(component -> component.addTags("Spring Repository"));
        toolKitRDatabase.addTags("Database");

        Styles styles = viewSet.getConfiguration().getStyles();
        styles.addElementStyle("Reflection Toolkit").background("#6CB33E").color("#ffffff");
        styles.addElementStyle(Tags.PERSON).background("#519823").color("#ffffff").shape(Shape.Person);
        styles.addElementStyle(Tags.CONTAINER).background("#91D366").color("#ffffff");
        styles.addElementStyle("Database").shape(Shape.Cylinder);

        styles.addElementStyle("Spring MVC Controller").background("#D4F3C0").color("#000000");
        styles.addElementStyle("Spring REST Controller").background("#D4FFC0").color("#000000");
        styles.addElementStyle("Spring Service").background("#6CB33E").color("#000000");
        styles.addElementStyle("Spring Repository").background("#95D46C").color("#000000");
        
    }
}
