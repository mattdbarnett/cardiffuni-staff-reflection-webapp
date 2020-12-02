package group03.project.web.controllers;

import group03.project.domain.Tag;
import group03.project.services.offered.TagService;
import group03.project.web.forms.TagCreationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

/**
 * Controller for navigating to directories in application relating to tags.
 */
@Controller
public class TagController {

    private TagService tagService;

    String adminAttribute = "";
    String pageChoice;

    /**
     * Links up the tag method interface into controller for accessing database changes.
     * @param aService
     */
    @Autowired
    public TagController(TagService aService) {
        tagService = aService;
        pageChoice = "user";
    }

    /**
     * Signifies navigation to "create-tag" html page, along with creating blank tag form
     * for appending.
     * @param model - html page used for parsing objects onto page.
     * @return - html page name
     */
    @GetMapping("/create-tag")
    public String showTagCreationForm(Model model) {
        TagCreationForm tagForm = new TagCreationForm();
        model.addAttribute("tag", tagForm);
        return pageChoice + "-create-tag";
    }

    /**
     * Builds a new tag object from html form & parses result into database via service.
     * @param tagForm - form object built from html entries.
     * @param result - result of validation on entries into form fields.
     * @return page redirection depending on success/failure of tag creation
     */
    @PostMapping("/tag-build")
    public String createNewTag(@ModelAttribute("tag") @Valid TagCreationForm tagForm,
                               BindingResult result) {

        if(!result.hasErrors()) {


            Tag newTag = createTag(tagForm);

            try {
                if (newTag.getIsOfficial()) {
                    tagService.createOfficialTag(newTag);
                } else {

                    tagService.createUnofficialTag(newTag);
                }

                return "redirect:/";
            } catch (NullPointerException e) {
                e.printStackTrace();
                System.out.println("failed to create tag");
                return "redirect:create-tag";
            }
        } else {
            return "redirect:create-tag";
        }
    }

    private Tag createTag(TagCreationForm tagForm) {

        Tag newTag;

        try {
            newTag = new Tag(
                    tagForm.getTagID(),
                    tagForm.getDescription(),
                    Boolean.parseBoolean(tagForm.getIsOfficial()));

        } catch (Exception ex) {
            return null;
        }
        return newTag;
    }
    
}
