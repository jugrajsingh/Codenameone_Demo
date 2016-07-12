/**
 * Your application code goes here<br>
 * This file was generated by <a href="https://www.codenameone.com/">Codename One</a> for the purpose 
 * of building native mobile applications using Java.
 */


package userclasses;

import ca.weblite.codename1.json.JSONArray;
import ca.weblite.codename1.json.JSONException;
import ca.weblite.codename1.json.JSONObject;
import com.codename1.components.InfiniteProgress;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.io.Util;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.*;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.list.ListModel;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.singhjugraj.demo.Server_APIs;
import generated.StateMachineBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Your name here
 */
public class StateMachine extends StateMachineBase {
    public StateMachine(String resFile) {
        super(resFile);
        // do not modify, write code in initVars and initialize class members there,
        // the constructor might be invoked too late due to race conditions that might occur
    }
    
    /**
     * this method should be used to initialize variables instead of
     * the constructor/class scope to avoid race conditions
     */
    protected void initVars(Resources res) {
    }


    @Override
    protected void beforeDataEntry(Form f) {
        List cmp = findList();
        final String[] responseString = {""};
        ConnectionRequest request = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream input) throws IOException {
                responseString[0] = Util.readToString(input);
            }
        };
        request.setPost(false);
        request.setUrl(Server_APIs.USERDATA);
        request.addArgument("user", Server_APIs.USERNAME);
        InfiniteProgress ip = new InfiniteProgress();
        Dialog dig = ip.showInifiniteBlocking();
        request.setDisposeOnCompletion(dig);
        NetworkManager.getInstance().addToQueueAndWait(request);
        int reqcode = request.getResponseCode();
        if (reqcode == 200) {
            ArrayList<Hashtable<String, String>> a = new ArrayList<>();
            try {
                JSONArray jArray = new JSONArray(responseString[0]);
                JSONObject obj = jArray.getJSONObject(0);
                if (!obj.getString("user_data").equals("null")) {
                    JSONArray jsonArray = new JSONArray(obj.getString("user_data"));
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject object = jsonArray.getJSONObject(i);
                        Hashtable<String, String> h = new Hashtable<>();
                        h.put("type", object.getString("type"));
                        h.put("data", object.getString("data"));
                        a.add(h);
                        cmp.setModel(new DefaultListModel<>(a));
                    }
                } else {
                    Hashtable<String, String> h = new Hashtable<>();
                    h.put("type", "Not Available");
                    h.put("data", "Please add your First Entry");
                    a.add(h);
                    cmp.setModel(new DefaultListModel<>(a));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        cmp.addPullToRefresh(() -> {
            beforeDataEntry(f);
            f.revalidate();
        });
    }

    @Override
    protected void beforeOwnerDetails(Form f) {
        final String[] responseString = new String[1];
        Picker picker = findDatePicker();
        picker.setType(Display.PICKER_TYPE_DATE);
        picker.setFormatter(new SimpleDateFormat("yyyy-MM-dd"));
        ConnectionRequest request = new ConnectionRequest() {
            @Override
            protected void readResponse(InputStream input) throws IOException {
                responseString[0] = Util.readToString(input);
            }
        };
        request.setUrl(Server_APIs.USERDETAILS);
        request.setPost(false);
        request.addArgument("user", Server_APIs.USERNAME);
        InfiniteProgress ip = new InfiniteProgress();
        Dialog dig = ip.showInifiniteBlocking();
        request.setDisposeOnCompletion(dig);
        NetworkManager.getInstance().addToQueueAndWait(request);
        if (request.getResponseCode() == 200) {
            try {
                JSONArray jArray = new JSONArray(responseString[0]);
                JSONObject jsonObject = jArray.getJSONObject(0);
                findFirstName().setText(jsonObject.getString("firstname"));
                findLastName().setText(jsonObject.getString("lastname"));
                findUsername().setText(jsonObject.getString("username"));
                findPassword().setText(jsonObject.getString("password"));
                findRepassword().setText(jsonObject.getString("password"));
                findEmail().setText(jsonObject.getString("email"));
                if (jsonObject.getString("gender").equalsIgnoreCase("male")) {
                    findMale().setSelected(true);
                } else {
                    findFemale().setSelected(true);
                }
                findComments().setText(jsonObject.getString("comments"));
                findDatePicker().setDate(new SimpleDateFormat("yyyy-MM-dd").parse(jsonObject.getString("dateofbirth")));
            } catch (JSONException | ParseException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onDataEntry_NewEntryButtonAction(Component c, ActionEvent event) {
        Dialog dialog = new Dialog();
        dialog.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label labelenter = new Label("Enter Label");
        Label labeldata = new Label("Enter Data ");
        TextField enterLabel = new TextField();
        enterLabel.setHint("Please Specify Label");
        enterLabel.setColumns(45);
        TextField enterData = new TextField();
        enterData.setHint("Please Enter Data");
        enterData.setColumns(45);
        Button okButtonNewEntry = new Button("Ok");
        Container container1 = new Container();
        container1.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        container1.add(labelenter);
        container1.add(enterLabel);
        Container container2 = new Container();
        container2.setLayout(new BoxLayout(BoxLayout.X_AXIS));
        container2.add(labeldata);
        container2.add(enterData);
        dialog.add(container1);
        dialog.add(container2);
        dialog.add(okButtonNewEntry);
        okButtonNewEntry.addActionListener(evt -> {
            List list = findList(c);
            ListModel model = list.getModel();
            Hashtable<String, String> hashtable = new Hashtable<>();
            hashtable.put("type", enterLabel.getText());
            hashtable.put("data", enterData.getText());
            model.addItem(hashtable);
            dialog.dispose();
        });
        dialog.setDisposeWhenPointerOutOfBounds(true);
        dialog.show();
    }

    @Override
    protected void onOwnerDetails_SubmitAction(Component c, ActionEvent event) {
        String requestBody;
        try {
            requestBody = "newusername=" + findUsername().getText();
            requestBody = requestBody + "&password=" + findPassword().getText();
            requestBody = requestBody + "&dob=" + findDatePicker().getText();
            requestBody = requestBody + "&email=" + findEmail().getText();
            requestBody = requestBody + "&firstname=" + findFirstName().getText();
            requestBody = requestBody + "&lastname=" + findLastName().getText();
            requestBody = requestBody + "&comments=" + findComments().getText();
            String gender;
            if (findMale().isSelected()) {
                gender = "male";
            } else {
                gender = "female";
            }
            requestBody = requestBody + "&gender=" + gender;
            String finalRequestBody = requestBody;
            ConnectionRequest request = new ConnectionRequest() {
                @Override
                protected void buildRequestBody(OutputStream os) throws IOException {
                    os.write(finalRequestBody.getBytes());
                }
            };
            request.setUrl(Server_APIs.USERDETAILS + "?user=" + Server_APIs.USERNAME);
            request.setContentType("application/x-www-form-urlencoded");
            request.setPost(true);
            InfiniteProgress ip = new InfiniteProgress();
            Dialog dig = ip.showInifiniteBlocking();
            request.setDisposeOnCompletion(dig);
            NetworkManager.getInstance().addToQueueAndWait(request);
            request.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDataEntry_SaveButtonAction(Component c, ActionEvent event) {
        List list = findList(c);
        Hashtable hashtable;
        JSONArray array = new JSONArray();
        ListModel model = list.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            hashtable = (Hashtable) model.getItemAt(i);
            JSONObject object = new JSONObject();
            try {
                object.put("type", hashtable.get("type"));
                object.put("data", hashtable.get("data"));
                array.put(object);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ConnectionRequest request = new ConnectionRequest() {
            @Override
            protected void buildRequestBody(OutputStream os) throws IOException {
                String send = "data=" + array.toString();
                os.write(send.getBytes());
            }
        };
        request.setUrl(Server_APIs.USERDATA + "?user=" + Server_APIs.USERNAME);
        request.setPost(true);
        request.setContentType("application/x-www-form-urlencoded");
        InfiniteProgress ip = new InfiniteProgress();
        Dialog dig = ip.showInifiniteBlocking();
        request.setDisposeOnCompletion(dig);
        NetworkManager.getInstance().addToQueueAndWait(request);
    }
}
