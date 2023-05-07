package eu.blockchainpanda.ethereum.pandafu.commons.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;

import java.math.BigInteger;
import java.util.Objects;

/**********************************************************************************************************************
 * This class represents the master credentials of a BIP-39 wallet, including its mnemonic, master private key,
 * and master public key. The class acts as a Data Transfer Object.
 *
 * BIP-39 wallets are a type of hierarchical deterministic (HD) wallet that uses a mnemonic phrase or seed to
 * generate a master keypair, which can then be used to derive a series of child keypairs, including both private
 * and public keys. Each child keypair corresponds to a specific public address on the blockchain.
 *
 *  @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/
@Builder
public class MasterCredentials {

    /******************************************************************************************************************
     * The mnemonic of the BIP-39 wallet. In essence, it is a sequence of 12 short words.
     *****************************************************************************************************************/
    private String mnemonic;

    /******************************************************************************************************************
     * The master private key of the BIP-39 wallet.
     *****************************************************************************************************************/
    private BigInteger masterPrivateKey;

    /******************************************************************************************************************
     * The master public key of the BIP-39 wallet.
     *****************************************************************************************************************/
    private BigInteger masterPublicKey;

    /******************************************************************************************************************
     * Constructor of the MasterCredentials class, initializing all parameters.
     *
     * @param mnemonic the mnemonic of the BIP-39 wallet, not null.
     * @param masterPrivateKey the master private key of the BIP-39 wallet, not null.
     * @param masterPublicKey the master public key of the BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public MasterCredentials(String mnemonic, BigInteger masterPrivateKey, BigInteger masterPublicKey) {
        this.mnemonic = mnemonic;
        this.masterPrivateKey = masterPrivateKey;
        this.masterPublicKey = masterPublicKey;
    }

    /******************************************************************************************************************
     * Empty constructor of the MasterCredentials class, initializing all parameters with their defaults.
     *****************************************************************************************************************/
    public MasterCredentials() {
    }

    /******************************************************************************************************************
     * Getter for the mnemonic attribute of the MasterCredentials class.
     *
     * @return the present value of the mnemonic attribute.
     *****************************************************************************************************************/
    public String getMnemonic() {
        return mnemonic;
    }

    /******************************************************************************************************************
     * Setter for the mnemonic attribute of the MasterCredentials class.
     *
     * @param mnemonic the mnemonic of the BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public void setMnemonic(String mnemonic) {
        this.mnemonic = mnemonic;
    }

    /******************************************************************************************************************
     * Getter for the masterPrivateKey attribute of the MasterCredentials class.
     *
     * @return the present value of the masterPrivateKey attribute.
     *****************************************************************************************************************/
    public BigInteger getMasterPrivateKey() {
        return masterPrivateKey;
    }

    /******************************************************************************************************************
     * Setter for the masterPrivateKey attribute of the MasterCredentials class.
     *
     * @param masterPrivateKey the master private key of the BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public void setMasterPrivateKey(BigInteger masterPrivateKey) {
        this.masterPrivateKey = masterPrivateKey;
    }

    /******************************************************************************************************************
     * Getter for the masterPublicKey attribute of the MasterCredentials class.
     *
     * @return the present value of the masterPublicKey attribute.
     *****************************************************************************************************************/
    public BigInteger getMasterPublicKey() {
        return masterPublicKey;
    }

    /******************************************************************************************************************
     * Setter for the masterPublicKey attribute of the MasterCredentials class.
     *
     * @param masterPublicKey the master public key of the BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public void setMasterPublicKey(BigInteger masterPublicKey) {
        this.masterPublicKey = masterPublicKey;
    }

    /******************************************************************************************************************
     * Method that checks whether a MasterCredentials object is equal to the present MasterCredentials object.
     *
     * @param o a MasterCredentials object to compare with the present, not null.
     *
     * @return a boolean answering whether the two objects are in fact the same.
     *****************************************************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MasterCredentials that = (MasterCredentials) o;
        return Objects.equals(mnemonic, that.mnemonic);
    }

    /******************************************************************************************************************
     * Method that returns a hash code value for the present MasterCredentials object.
     *
     * @return a hash code value for the present object.
     *****************************************************************************************************************/
    @Override
    public int hashCode() {
        return Objects.hash(mnemonic);
    }

    /******************************************************************************************************************
     * Method that returns the string representation of the present MasterCredentials object.
     *
     * @return a string representation of the present object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "MasterCredentials {" +
                "Mnemonic: '" + mnemonic + '\'' +
                ", Master Private Key: " + masterPrivateKey +
                ", Master Public Key: " + masterPublicKey +
                '}';
    }

    /******************************************************************************************************************
     * Method that returns a JSON representation of the present MasterCredentials object.
     *
     * @return a JSON representation of the present object.
     *****************************************************************************************************************/
    public String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
