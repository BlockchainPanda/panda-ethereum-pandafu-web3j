package eu.blockchainpanda.ethereum.pandafu.commons.serializers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import org.web3j.crypto.Credentials;

import java.lang.reflect.Type;

/*********************************************************************************************************************
 * A custom serializer for the Credentials class from the Web3j library. Serializes a Credentials object to a JSON
 * object with the public address as a string.
 *
 *  @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/
public class CredentialsSerializer implements JsonSerializer<Credentials> {


    /******************************************************************************************************************
     * Serializes a Credentials object to a JSON object with the public and private addresses as strings.
     *
     * @param credentials the Credentials object to serialize, not null
     * @param type the type of the object to serialize
     * @param context the JSON serialization context
     *
     * @return a JSON element representing the serialized Credentials object
     *****************************************************************************************************************/
    @Override
    public JsonElement serialize(Credentials credentials, Type type, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("address", credentials.getAddress());
        jsonObject.addProperty("privateKey", credentials.getEcKeyPair().getPrivateKey().toString(16));
        return jsonObject;
    }
}
