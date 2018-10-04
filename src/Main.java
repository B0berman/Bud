import DAO.FileDao;
import DAO.JsonDAO;
import addon.IdentityConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        // load game etc.
        // init addons

        JsonDAO<IdentityConfig> jsonDAO = new JsonDAO<>(IdentityConfig.class);

        IdentityConfig ic = new IdentityConfig();
        ic.setDescription("descriptionoooon");
        ic.setName("naaame");
        ic.setType(IdentityConfig.AO_TYPE.MODEL);

        System.out.println(jsonDAO.write(ic));

        String json = "{\"type\":\"MODEL\",\"name\":\"naaZZZZame\",\"description\":\"descriptionoooon\",\"version\":0.0}";
        IdentityConfig unInt = jsonDAO.read(json);

        System.out.println(unInt.getName());

        FileDao fileDao = new FileDao("toto.txt");
        System.out.println(fileDao.read(null));

    }//end of main

}