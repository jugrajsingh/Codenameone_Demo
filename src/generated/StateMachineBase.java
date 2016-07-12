/**
 * This class contains generated code from the Codename One Designer, DO NOT MODIFY!
 * This class is designed for subclassing that way the code generator can overwrite it
 * anytime without erasing your changes which should exist in a subclass!
 * For details about this file and how it works please read this blog post:
 * http://codenameone.blogspot.com/2010/10/ui-builder-class-how-to-actually-use.html
*/
package generated;

import com.codename1.io.Preferences;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.ui.util.UIBuilder;
import com.singhjugraj.demo.Server_APIs;

import java.util.Hashtable;

public abstract class StateMachineBase extends UIBuilder {
    public static final int COMMAND_MainGoToUserDetails = 2;
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    public static final int COMMAND_MainGoToDataEntry = 1;
    public static final int COMMAND_MainLogin = 3;
    private Container aboutToShowThisContainer;

    public StateMachineBase(Resources res, String resPath, boolean loadTheme) {
        startApp(res, resPath, loadTheme);
    }

    public StateMachineBase() {
    }

    public StateMachineBase(String resPath) {
        this(null, resPath, true);
    }

    public StateMachineBase(Resources res) {
        this(res, null, true);
    }

    public StateMachineBase(String resPath, boolean loadTheme) {
        this(null, resPath, loadTheme);
    }

    public StateMachineBase(Resources res, boolean loadTheme) {
        this(res, null, loadTheme);
    }

    /**
    * @deprecated use the version that accepts a resource as an argument instead

**/
    protected void initVars() {}

    protected void initVars(Resources res) {}

    public Container startApp(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("ComponentGroup", com.codename1.ui.ComponentGroup.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    if(resPath.endsWith(".res")) {
                        res = Resources.open(resPath);
                        System.out.println("Warning: you should construct the state machine without the .res extension to allow theme overlays");
                    } else {
                        res = Resources.openLayered(resPath);
                    }
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        if(res != null) {
            setResourceFilePath(resPath);
            setResourceFile(res);
            initVars(res);
            return showForm(getFirstFormName(), null);
        } else {
            Form f = (Form)createContainer(resPath, getFirstFormName());
            initVars(fetchResourceFile());
            beforeShow(f);
            f.show();
            postShow(f);
            return f;
        }
    }

    protected String getFirstFormName() {
        String username = Preferences.get("username", "DEFAULT");
        if (username.equalsIgnoreCase("DEFAULT")) {
            return "LoginForm";
        } else {
            Server_APIs.USERNAME = username;
            return "Main";
        }
    }

    public Container createWidget(Resources res, String resPath, boolean loadTheme) {
        initVars();
        UIBuilder.registerCustomComponent("Container", com.codename1.ui.Container.class);
        UIBuilder.registerCustomComponent("ComponentGroup", com.codename1.ui.ComponentGroup.class);
        UIBuilder.registerCustomComponent("Form", com.codename1.ui.Form.class);
        UIBuilder.registerCustomComponent("TextArea", com.codename1.ui.TextArea.class);
        UIBuilder.registerCustomComponent("Button", com.codename1.ui.Button.class);
        UIBuilder.registerCustomComponent("Picker", com.codename1.ui.spinner.Picker.class);
        UIBuilder.registerCustomComponent("Label", com.codename1.ui.Label.class);
        UIBuilder.registerCustomComponent("TextField", com.codename1.ui.TextField.class);
        UIBuilder.registerCustomComponent("Tabs", com.codename1.ui.Tabs.class);
        UIBuilder.registerCustomComponent("List", com.codename1.ui.List.class);
        UIBuilder.registerCustomComponent("RadioButton", com.codename1.ui.RadioButton.class);
        if(loadTheme) {
            if(res == null) {
                try {
                    res = Resources.openLayered(resPath);
                } catch(java.io.IOException err) { err.printStackTrace(); }
            }
            initTheme(res);
        }
        return createContainer(resPath, "Main");
    }

    protected void initTheme(Resources res) {
            String[] themes = res.getThemeResourceNames();
            if(themes != null && themes.length > 0) {
                UIManager.getInstance().setThemeProps(res.getTheme(themes[0]));
            }
    }

    public com.codename1.ui.Button findCancel(Component root) {
        return (com.codename1.ui.Button)findByName("cancel", root);
    }

    public com.codename1.ui.Button findCancel() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("cancel", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("cancel", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComponentGroup findComponentGroup(Component root) {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup", root);
    }

    public com.codename1.ui.ComponentGroup findComponentGroup() {
        com.codename1.ui.ComponentGroup cmp = (com.codename1.ui.ComponentGroup)findByName("ComponentGroup", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComponentGroup)findByName("ComponentGroup", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findLoginUsername(Component root) {
        return (com.codename1.ui.TextField)findByName("loginUsername", root);
    }

    public com.codename1.ui.TextField findLoginUsername() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("loginUsername", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("loginUsername", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findData(Component root) {
        return (com.codename1.ui.Label)findByName("data", root);
    }

    public com.codename1.ui.Label findData() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("data", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("data", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findLoginSubmit(Component root) {
        return (com.codename1.ui.Button)findByName("loginSubmit", root);
    }

    public com.codename1.ui.Button findLoginSubmit() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("loginSubmit", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("loginSubmit", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel(Component root) {
        return (com.codename1.ui.Label)findByName("Label", root);
    }

    public com.codename1.ui.Label findLabel() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer3(Component root) {
        return (com.codename1.ui.Container)findByName("Container3", root);
    }

    public com.codename1.ui.Container findContainer3() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer4(Component root) {
        return (com.codename1.ui.Container)findByName("Container4", root);
    }

    public com.codename1.ui.Container findContainer4() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container4", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container4", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer1(Component root) {
        return (com.codename1.ui.Container)findByName("Container1", root);
    }

    public com.codename1.ui.Container findContainer1() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer2(Component root) {
        return (com.codename1.ui.Container)findByName("Container2", root);
    }

    public com.codename1.ui.Container findContainer2() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findType(Component root) {
        return (com.codename1.ui.Label)findByName("type", root);
    }

    public com.codename1.ui.Label findType() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("type", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("type", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findLogincontainer(Component root) {
        return (com.codename1.ui.Container)findByName("logincontainer", root);
    }

    public com.codename1.ui.Container findLogincontainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("logincontainer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("logincontainer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findSignupRePassword(Component root) {
        return (com.codename1.ui.TextField)findByName("signupRePassword", root);
    }

    public com.codename1.ui.TextField findSignupRePassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("signupRePassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("signupRePassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findPassword(Component root) {
        return (com.codename1.ui.TextField)findByName("password", root);
    }

    public com.codename1.ui.TextField findPassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("password", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("password", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findContainer(Component root) {
        return (com.codename1.ui.Container)findByName("Container", root);
    }

    public com.codename1.ui.Container findContainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("Container", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("Container", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findLoginPassword(Component root) {
        return (com.codename1.ui.TextField)findByName("loginPassword", root);
    }

    public com.codename1.ui.TextField findLoginPassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("loginPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("loginPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findSignupEmail(Component root) {
        return (com.codename1.ui.TextField)findByName("signupEmail", root);
    }

    public com.codename1.ui.TextField findSignupEmail() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("signupEmail", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("signupEmail", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.List findList(Component root) {
        return (com.codename1.ui.List)findByName("List", root);
    }

    public com.codename1.ui.List findList() {
        com.codename1.ui.List cmp = (com.codename1.ui.List)findByName("List", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.List)findByName("List", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findListRenderer(Component root) {
        return (com.codename1.ui.Container)findByName("listRenderer", root);
    }

    public com.codename1.ui.Container findListRenderer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("listRenderer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("listRenderer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findFemale(Component root) {
        return (com.codename1.ui.RadioButton)findByName("female", root);
    }

    public com.codename1.ui.RadioButton findFemale() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("female", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("female", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findNewEntryButton(Component root) {
        return (com.codename1.ui.Button)findByName("newEntryButton", root);
    }

    public com.codename1.ui.Button findNewEntryButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("newEntryButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("newEntryButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findSignupSubmit(Component root) {
        return (com.codename1.ui.Button)findByName("signupSubmit", root);
    }

    public com.codename1.ui.Button findSignupSubmit() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("signupSubmit", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("signupSubmit", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findSignupFirstname(Component root) {
        return (com.codename1.ui.TextField)findByName("signupFirstname", root);
    }

    public com.codename1.ui.TextField findSignupFirstname() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("signupFirstname", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("signupFirstname", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findDatePicker(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("datePicker", root);
    }

    public com.codename1.ui.spinner.Picker findDatePicker() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("datePicker", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("datePicker", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findSignupUsername(Component root) {
        return (com.codename1.ui.TextField)findByName("signupUsername", root);
    }

    public com.codename1.ui.TextField findSignupUsername() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("signupUsername", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("signupUsername", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findGotouserdetails(Component root) {
        return (com.codename1.ui.Button)findByName("gotouserdetails", root);
    }

    public com.codename1.ui.Button findGotouserdetails() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("gotouserdetails", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("gotouserdetails", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findFirstName(Component root) {
        return (com.codename1.ui.TextField)findByName("firstName", root);
    }

    public com.codename1.ui.TextField findFirstName() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("firstName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("firstName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.spinner.Picker findSignupdatePicker(Component root) {
        return (com.codename1.ui.spinner.Picker)findByName("signupdatePicker", root);
    }

    public com.codename1.ui.spinner.Picker findSignupdatePicker() {
        com.codename1.ui.spinner.Picker cmp = (com.codename1.ui.spinner.Picker)findByName("signupdatePicker", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.spinner.Picker)findByName("signupdatePicker", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findScanit(Component root) {
        return (com.codename1.ui.Button)findByName("scanit", root);
    }

    public com.codename1.ui.Button findScanit() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("scanit", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("scanit", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Tabs findTabs(Component root) {
        return (com.codename1.ui.Tabs)findByName("Tabs", root);
    }

    public com.codename1.ui.Tabs findTabs() {
        com.codename1.ui.Tabs cmp = (com.codename1.ui.Tabs)findByName("Tabs", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Tabs)findByName("Tabs", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findMale(Component root) {
        return (com.codename1.ui.RadioButton)findByName("male", root);
    }

    public com.codename1.ui.RadioButton findMale() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("male", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("male", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findSignupmale(Component root) {
        return (com.codename1.ui.RadioButton)findByName("signupmale", root);
    }

    public com.codename1.ui.RadioButton findSignupmale() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("signupmale", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("signupmale", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findLastName(Component root) {
        return (com.codename1.ui.TextField)findByName("lastName", root);
    }

    public com.codename1.ui.TextField findLastName() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("lastName", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("lastName", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findSubmit(Component root) {
        return (com.codename1.ui.Button)findByName("submit", root);
    }

    public com.codename1.ui.Button findSubmit() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("submit", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("submit", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findSignupcnt(Component root) {
        return (com.codename1.ui.Container)findByName("signupcnt", root);
    }

    public com.codename1.ui.Container findSignupcnt() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("signupcnt", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("signupcnt", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.ComponentGroup findComponentGroup1(Component root) {
        return (com.codename1.ui.ComponentGroup)findByName("ComponentGroup1", root);
    }

    public com.codename1.ui.ComponentGroup findComponentGroup1() {
        com.codename1.ui.ComponentGroup cmp = (com.codename1.ui.ComponentGroup)findByName("ComponentGroup1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.ComponentGroup)findByName("ComponentGroup1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel8(Component root) {
        return (com.codename1.ui.Label)findByName("Label8", root);
    }

    public com.codename1.ui.Label findLabel8() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label8", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label8", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findSignupLastname(Component root) {
        return (com.codename1.ui.TextField)findByName("signupLastname", root);
    }

    public com.codename1.ui.TextField findSignupLastname() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("signupLastname", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("signupLastname", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findSignupPassword(Component root) {
        return (com.codename1.ui.TextField)findByName("signupPassword", root);
    }

    public com.codename1.ui.TextField findSignupPassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("signupPassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("signupPassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel5(Component root) {
        return (com.codename1.ui.Label)findByName("Label5", root);
    }

    public com.codename1.ui.Label findLabel5() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label5", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label5", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findSignupcontainer(Component root) {
        return (com.codename1.ui.Container)findByName("signupcontainer", root);
    }

    public com.codename1.ui.Container findSignupcontainer() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("signupcontainer", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("signupcontainer", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel7(Component root) {
        return (com.codename1.ui.Label)findByName("Label7", root);
    }

    public com.codename1.ui.Label findLabel7() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label7", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label7", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel6(Component root) {
        return (com.codename1.ui.Label)findByName("Label6", root);
    }

    public com.codename1.ui.Label findLabel6() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label6", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label6", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findSaveButton(Component root) {
        return (com.codename1.ui.Button)findByName("saveButton", root);
    }

    public com.codename1.ui.Button findSaveButton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("saveButton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("saveButton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findLoginbutton(Component root) {
        return (com.codename1.ui.Button)findByName("loginbutton", root);
    }

    public com.codename1.ui.Button findLoginbutton() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("loginbutton", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("loginbutton", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findEmail(Component root) {
        return (com.codename1.ui.TextField)findByName("email", root);
    }

    public com.codename1.ui.TextField findEmail() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("email", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("email", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextArea findComments(Component root) {
        return (com.codename1.ui.TextArea)findByName("comments", root);
    }

    public com.codename1.ui.TextArea findComments() {
        com.codename1.ui.TextArea cmp = (com.codename1.ui.TextArea)findByName("comments", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextArea)findByName("comments", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Button findGotodataentry(Component root) {
        return (com.codename1.ui.Button)findByName("gotodataentry", root);
    }

    public com.codename1.ui.Button findGotodataentry() {
        com.codename1.ui.Button cmp = (com.codename1.ui.Button)findByName("gotodataentry", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Button)findByName("gotodataentry", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.RadioButton findSignupfemale(Component root) {
        return (com.codename1.ui.RadioButton)findByName("signupfemale", root);
    }

    public com.codename1.ui.RadioButton findSignupfemale() {
        com.codename1.ui.RadioButton cmp = (com.codename1.ui.RadioButton)findByName("signupfemale", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.RadioButton)findByName("signupfemale", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel1(Component root) {
        return (com.codename1.ui.Label)findByName("Label1", root);
    }

    public com.codename1.ui.Label findLabel1() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label1", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label1", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel3(Component root) {
        return (com.codename1.ui.Label)findByName("Label3", root);
    }

    public com.codename1.ui.Label findLabel3() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label3", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label3", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Label findLabel2(Component root) {
        return (com.codename1.ui.Label)findByName("Label2", root);
    }

    public com.codename1.ui.Label findLabel2() {
        com.codename1.ui.Label cmp = (com.codename1.ui.Label)findByName("Label2", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Label)findByName("Label2", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.Container findLogincnt(Component root) {
        return (com.codename1.ui.Container)findByName("logincnt", root);
    }

    public com.codename1.ui.Container findLogincnt() {
        com.codename1.ui.Container cmp = (com.codename1.ui.Container)findByName("logincnt", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.Container)findByName("logincnt", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findRepassword(Component root) {
        return (com.codename1.ui.TextField)findByName("repassword", root);
    }

    public com.codename1.ui.TextField findRepassword() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("repassword", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("repassword", aboutToShowThisContainer);
        }
        return cmp;
    }

    public com.codename1.ui.TextField findUsername(Component root) {
        return (com.codename1.ui.TextField)findByName("username", root);
    }

    public com.codename1.ui.TextField findUsername() {
        com.codename1.ui.TextField cmp = (com.codename1.ui.TextField)findByName("username", Display.getInstance().getCurrent());
        if(cmp == null && aboutToShowThisContainer != null) {
            cmp = (com.codename1.ui.TextField)findByName("username", aboutToShowThisContainer);
        }
        return cmp;
    }

    protected boolean onMainGoToUserDetails() {
        return false;
    }

    protected boolean onMainGoToDataEntry() {
        return false;
    }

    protected boolean onMainLogin() {
        return false;
    }

    protected void processCommand(ActionEvent ev, Command cmd) {
        switch(cmd.getId()) {
            case COMMAND_MainGoToUserDetails:
                if(onMainGoToUserDetails()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainGoToDataEntry:
                if(onMainGoToDataEntry()) {
                    ev.consume();
                    return;
                }
                break;

            case COMMAND_MainLogin:
                if(onMainLogin()) {
                    ev.consume();
                    return;
                }
                break;

        }
        if(ev.getComponent() != null) {
            handleComponentAction(ev.getComponent(), ev);
        }
    }

    protected void exitForm(Form f) {
        if("OwnerDetails".equals(f.getName())) {
            exitOwnerDetails(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(f.getName())) {
            exitDataEntry(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(f.getName())) {
            exitLoginForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(f.getName())) {
            exitListRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            exitMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void exitOwnerDetails(Form f) {
    }


    protected void exitDataEntry(Form f) {
    }


    protected void exitLoginForm(Form f) {
    }


    protected void exitListRenderer(Form f) {
    }


    protected void exitMain(Form f) {
    }

    protected void beforeShow(Form f) {
    aboutToShowThisContainer = f;
        if("OwnerDetails".equals(f.getName())) {
            beforeOwnerDetails(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(f.getName())) {
            beforeDataEntry(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(f.getName())) {
            beforeLoginForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(f.getName())) {
            beforeListRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            beforeMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeOwnerDetails(Form f) {
    }


    protected void beforeDataEntry(Form f) {
    }


    protected void beforeLoginForm(Form f) {
    }


    protected void beforeListRenderer(Form f) {
    }


    protected void beforeMain(Form f) {
    }

    protected void beforeShowContainer(Container c) {
        aboutToShowThisContainer = c;
        if("OwnerDetails".equals(c.getName())) {
            beforeContainerOwnerDetails(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(c.getName())) {
            beforeContainerDataEntry(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(c.getName())) {
            beforeContainerLoginForm(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(c.getName())) {
            beforeContainerListRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            beforeContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void beforeContainerOwnerDetails(Container c) {
    }


    protected void beforeContainerDataEntry(Container c) {
    }


    protected void beforeContainerLoginForm(Container c) {
    }


    protected void beforeContainerListRenderer(Container c) {
    }


    protected void beforeContainerMain(Container c) {
    }

    protected void postShow(Form f) {
        if("OwnerDetails".equals(f.getName())) {
            postOwnerDetails(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(f.getName())) {
            postDataEntry(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(f.getName())) {
            postLoginForm(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(f.getName())) {
            postListRenderer(f);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            postMain(f);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postOwnerDetails(Form f) {
    }


    protected void postDataEntry(Form f) {
    }


    protected void postLoginForm(Form f) {
    }


    protected void postListRenderer(Form f) {
    }


    protected void postMain(Form f) {
    }

    protected void postShowContainer(Container c) {
        if("OwnerDetails".equals(c.getName())) {
            postContainerOwnerDetails(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(c.getName())) {
            postContainerDataEntry(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(c.getName())) {
            postContainerLoginForm(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(c.getName())) {
            postContainerListRenderer(c);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(c.getName())) {
            postContainerMain(c);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void postContainerOwnerDetails(Container c) {
    }


    protected void postContainerDataEntry(Container c) {
    }


    protected void postContainerLoginForm(Container c) {
    }


    protected void postContainerListRenderer(Container c) {
    }


    protected void postContainerMain(Container c) {
    }

    protected void onCreateRoot(String rootName) {
        if("OwnerDetails".equals(rootName)) {
            onCreateOwnerDetails();
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(rootName)) {
            onCreateDataEntry();
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(rootName)) {
            onCreateLoginForm();
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(rootName)) {
            onCreateListRenderer();
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(rootName)) {
            onCreateMain();
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void onCreateOwnerDetails() {
    }


    protected void onCreateDataEntry() {
    }


    protected void onCreateLoginForm() {
    }


    protected void onCreateListRenderer() {
    }


    protected void onCreateMain() {
    }

    protected Hashtable getFormState(Form f) {
        Hashtable h = super.getFormState(f);
        if("OwnerDetails".equals(f.getName())) {
            getStateOwnerDetails(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Data Entry".equals(f.getName())) {
            getStateDataEntry(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("LoginForm".equals(f.getName())) {
            getStateLoginForm(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("listRenderer".equals(f.getName())) {
            getStateListRenderer(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

        if("Main".equals(f.getName())) {
            getStateMain(f, h);
            aboutToShowThisContainer = null;
            return h;
        }

            return h;
    }


    protected void getStateOwnerDetails(Form f, Hashtable h) {
    }


    protected void getStateDataEntry(Form f, Hashtable h) {
    }


    protected void getStateLoginForm(Form f, Hashtable h) {
    }


    protected void getStateListRenderer(Form f, Hashtable h) {
    }


    protected void getStateMain(Form f, Hashtable h) {
    }

    protected void setFormState(Form f, Hashtable state) {
        super.setFormState(f, state);
        if("OwnerDetails".equals(f.getName())) {
            setStateOwnerDetails(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Data Entry".equals(f.getName())) {
            setStateDataEntry(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("LoginForm".equals(f.getName())) {
            setStateLoginForm(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("listRenderer".equals(f.getName())) {
            setStateListRenderer(f, state);
            aboutToShowThisContainer = null;
            return;
        }

        if("Main".equals(f.getName())) {
            setStateMain(f, state);
            aboutToShowThisContainer = null;
            return;
        }

            return;
    }


    protected void setStateOwnerDetails(Form f, Hashtable state) {
    }


    protected void setStateDataEntry(Form f, Hashtable state) {
    }


    protected void setStateLoginForm(Form f, Hashtable state) {
    }


    protected void setStateListRenderer(Form f, Hashtable state) {
    }


    protected void setStateMain(Form f, Hashtable state) {
    }

    protected boolean setListModel(List cmp) {
        String listName = cmp.getName();
        if("List".equals(listName)) {
            return initListModelList(cmp);
        }
        return super.setListModel(cmp);
    }

    protected boolean initListModelList(List cmp) {
        return false;
    }

    protected void handleComponentAction(Component c, ActionEvent event) {
        Container rootContainerAncestor = getRootAncestor(c);
        if(rootContainerAncestor == null) return;
        String rootContainerName = rootContainerAncestor.getName();
        Container leadParentContainer = c.getParent().getLeadParent();
        if(leadParentContainer != null && leadParentContainer.getClass() != Container.class) {
            c = c.getParent().getLeadParent();
        }
        if(rootContainerName == null) return;
        if(rootContainerName.equals("OwnerDetails")) {
            if("firstName".equals(c.getName())) {
                onOwnerDetails_FirstNameAction(c, event);
                return;
            }
            if("lastName".equals(c.getName())) {
                onOwnerDetails_LastNameAction(c, event);
                return;
            }
            if("username".equals(c.getName())) {
                onOwnerDetails_UsernameAction(c, event);
                return;
            }
            if("email".equals(c.getName())) {
                onOwnerDetails_EmailAction(c, event);
                return;
            }
            if("datePicker".equals(c.getName())) {
                onOwnerDetails_DatePickerAction(c, event);
                return;
            }
            if("password".equals(c.getName())) {
                onOwnerDetails_PasswordAction(c, event);
                return;
            }
            if("repassword".equals(c.getName())) {
                onOwnerDetails_RepasswordAction(c, event);
                return;
            }
            if("male".equals(c.getName())) {
                onOwnerDetails_MaleAction(c, event);
                return;
            }
            if("female".equals(c.getName())) {
                onOwnerDetails_FemaleAction(c, event);
                return;
            }
            if("comments".equals(c.getName())) {
                onOwnerDetails_CommentsAction(c, event);
                return;
            }
            if("submit".equals(c.getName())) {
                onOwnerDetails_SubmitAction(c, event);
                return;
            }
            if("cancel".equals(c.getName())) {
                onOwnerDetails_CancelAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Data Entry")) {
            if("List".equals(c.getName())) {
                onDataEntry_ListAction(c, event);
                return;
            }
            if("newEntryButton".equals(c.getName())) {
                onDataEntry_NewEntryButtonAction(c, event);
                return;
            }
            if("saveButton".equals(c.getName())) {
                onDataEntry_SaveButtonAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("LoginForm")) {
            if("loginUsername".equals(c.getName())) {
                onLoginForm_LoginUsernameAction(c, event);
                return;
            }
            if("loginPassword".equals(c.getName())) {
                onLoginForm_LoginPasswordAction(c, event);
                return;
            }
            if("loginSubmit".equals(c.getName())) {
                onLoginForm_LoginSubmitAction(c, event);
                return;
            }
            if("signupFirstname".equals(c.getName())) {
                onLoginForm_SignupFirstnameAction(c, event);
                return;
            }
            if("signupLastname".equals(c.getName())) {
                onLoginForm_SignupLastnameAction(c, event);
                return;
            }
            if("signupUsername".equals(c.getName())) {
                onLoginForm_SignupUsernameAction(c, event);
                return;
            }
            if("signupEmail".equals(c.getName())) {
                onLoginForm_SignupEmailAction(c, event);
                return;
            }
            if("signupPassword".equals(c.getName())) {
                onLoginForm_SignupPasswordAction(c, event);
                return;
            }
            if("signupRePassword".equals(c.getName())) {
                onLoginForm_SignupRePasswordAction(c, event);
                return;
            }
            if("signupdatePicker".equals(c.getName())) {
                onLoginForm_SignupdatePickerAction(c, event);
                return;
            }
            if("signupmale".equals(c.getName())) {
                onLoginForm_SignupmaleAction(c, event);
                return;
            }
            if("signupfemale".equals(c.getName())) {
                onLoginForm_SignupfemaleAction(c, event);
                return;
            }
            if("signupSubmit".equals(c.getName())) {
                onLoginForm_SignupSubmitAction(c, event);
                return;
            }
        }
        if(rootContainerName.equals("Main")) {
            if("gotodataentry".equals(c.getName())) {
                onMain_GotodataentryAction(c, event);
                return;
            }
            if("gotouserdetails".equals(c.getName())) {
                onMain_GotouserdetailsAction(c, event);
                return;
            }
            if("scanit".equals(c.getName())) {
                onMain_ScanitAction(c, event);
                return;
            }
            if("loginbutton".equals(c.getName())) {
                onMain_LoginbuttonAction(c, event);
                return;
            }
        }
    }

      protected void onOwnerDetails_FirstNameAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_LastNameAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_UsernameAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_EmailAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_DatePickerAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_PasswordAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_RepasswordAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_MaleAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_FemaleAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_CommentsAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_SubmitAction(Component c, ActionEvent event) {
      }

      protected void onOwnerDetails_CancelAction(Component c, ActionEvent event) {
      }

      protected void onDataEntry_ListAction(Component c, ActionEvent event) {
      }

      protected void onDataEntry_NewEntryButtonAction(Component c, ActionEvent event) {
      }

      protected void onDataEntry_SaveButtonAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_LoginUsernameAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_LoginPasswordAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_LoginSubmitAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupFirstnameAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupLastnameAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupUsernameAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupEmailAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupPasswordAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupRePasswordAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupdatePickerAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupmaleAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupfemaleAction(Component c, ActionEvent event) {
      }

      protected void onLoginForm_SignupSubmitAction(Component c, ActionEvent event) {
      }

      protected void onMain_GotodataentryAction(Component c, ActionEvent event) {
      }

      protected void onMain_GotouserdetailsAction(Component c, ActionEvent event) {
      }

      protected void onMain_ScanitAction(Component c, ActionEvent event) {
      }

      protected void onMain_LoginbuttonAction(Component c, ActionEvent event) {
      }

}
