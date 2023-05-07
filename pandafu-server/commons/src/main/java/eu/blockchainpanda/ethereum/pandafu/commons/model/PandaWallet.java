package eu.blockchainpanda.ethereum.pandafu.commons.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eu.blockchainpanda.ethereum.pandafu.commons.serializers.CredentialsSerializer;
import org.web3j.crypto.Credentials;

import java.util.Objects;
import java.util.Set;

public class PandaWallet {

    private Credentials masterKeyPair;

    private Set<Credentials> derivedKeyPairs;

    public PandaWallet(Credentials masterKeyPair, Set<Credentials> derivedKeyPairs) {
        this.masterKeyPair = masterKeyPair;
        this.derivedKeyPairs = derivedKeyPairs;
    }

    public PandaWallet() {

    }

    public Credentials getMasterKeyPair() {
        return masterKeyPair;
    }

    public void setMasterKeyPair(Credentials masterKeyPair) {
        this.masterKeyPair = masterKeyPair;
    }

    public Set<Credentials> getDerivedKeyPairs() {
        return derivedKeyPairs;
    }

    public void setDerivedKeyPairs(Set<Credentials> derivedKeyPairs) {
        this.derivedKeyPairs = derivedKeyPairs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PandaWallet that = (PandaWallet) o;
        return Objects.equals(masterKeyPair, that.masterKeyPair);
    }

    @Override
    public int hashCode() {
        return Objects.hash(masterKeyPair);
    }

    @Override
    public String toString() {
        return "PandaWallet {" +
                "Master KeyPair: " + masterKeyPair +
                ", Derived KeyPairs: " + derivedKeyPairs +
                '}';
    }

    public String toJSON() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(Credentials.class, new CredentialsSerializer())
                .create();
        return gson.toJson(this);
    }
}
