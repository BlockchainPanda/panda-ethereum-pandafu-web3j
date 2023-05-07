package eu.blockchainpanda.ethereum.pandafu.commons.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Builder;

import java.math.BigInteger;
import java.util.Objects;

/**********************************************************************************************************************
 * This class represents credentials derived from the master credentials of a BIP-39 wallet, including a private key,
 * a public key and a public address. The class acts as a Data Transfer Object.
 *
 * BIP-39 wallets are a type of hierarchical deterministic (HD) wallet that uses a mnemonic phrase or seed to
 * generate a master keypair, which can then be used to derive a series of child keypairs, including both private
 * and public keys. Each child keypair corresponds to a specific public address on the blockchain.
 *
 *  @author Angela-Maria Despotopoulou
 *********************************************************************************************************************/
@Builder
public class DerivedCredentials {

    /******************************************************************************************************************
     * A private key derived of the master credentials of a BIP-39 wallet.
     *****************************************************************************************************************/
    private BigInteger privateKey;

    /******************************************************************************************************************
     * A public key derived of the master credentials of a BIP-39 wallet.
     *****************************************************************************************************************/
    private BigInteger publicKey;

    /******************************************************************************************************************
     * A public address, able to receive ETH, associated with credentials derived of the master credentials of a BIP-39 wallet.
     *****************************************************************************************************************/
    private String publicAddress;

    /******************************************************************************************************************
     * Constructor of the DerivedCredentials class, initializing all parameters.
     *
     * @param privateKey private key derived of the master credentials of a BIP-39 wallet, not null.
     * @param publicKey public key derived of the master credentials of a BIP-39 wallet, not null.
     * @param publicAddress public address associated with credentials derived of the master credentials of a BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public DerivedCredentials(BigInteger privateKey, BigInteger publicKey, String publicAddress) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
        this.publicAddress = publicAddress;
    }

    /******************************************************************************************************************
     * Empty constructor of the DerivedCredentials class, initializing all parameters with their defaults.
     *****************************************************************************************************************/
    public DerivedCredentials() {
    }

    /******************************************************************************************************************
     * Getter for the privateKey attribute of the DerivedCredentials class.
     *
     * @return the present value of the privateKey attribute.
     *****************************************************************************************************************/
    public BigInteger getPrivateKey() {
        return privateKey;
    }

    /******************************************************************************************************************
     * Setter for the privateKey attribute of the DerivedCredentials class.
     *
     * @param privateKey private key derived of the master credentials of a BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public void setPrivateKey(BigInteger privateKey) {
        this.privateKey = privateKey;
    }

    /******************************************************************************************************************
     * Getter for the publicKey attribute of the DerivedCredentials class.
     *
     * @return the present value of the publicKey attribute.
     *****************************************************************************************************************/
    public BigInteger getPublicKey() {
        return publicKey;
    }

    /******************************************************************************************************************
     * Setter for the publicKey attribute of the DerivedCredentials class.
     *
     * @param publicKey public key derived of the master credentials of a BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public void setPublicKey(BigInteger publicKey) {
        this.publicKey = publicKey;
    }

    /******************************************************************************************************************
     * Getter for the publicAddress attribute of the DerivedCredentials class.
     *
     * @return the present value of the publicAddress attribute.
     *****************************************************************************************************************/
    public String getPublicAddress() {
        return publicAddress;
    }

    /******************************************************************************************************************
     * Setter for the publicAddress attribute of the DerivedCredentials class.
     *
     * @param publicAddress public address associated with credentials derived of the master credentials of a BIP-39 wallet, not null.
     *****************************************************************************************************************/
    public void setPublicAddress(String publicAddress) {
        this.publicAddress = publicAddress;
    }

    /******************************************************************************************************************
     * Method that checks whether a DerivedCredentials object is equal to the present DerivedCredentials object.
     *
     * @param o a DerivedCredentials object to compare with the present, not null.
     *
     * @return a boolean answering whether the two objects are in fact the same.
     *****************************************************************************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DerivedCredentials that = (DerivedCredentials) o;
        return Objects.equals(privateKey, that.privateKey);
    }

    /******************************************************************************************************************
     * Method that returns a hash code value for the present DerivedCredentials object.
     *
     * @return a hash code value for the present object.
     *****************************************************************************************************************/
    @Override
    public int hashCode() {
        return Objects.hash(privateKey);
    }

    /******************************************************************************************************************
     * Method that returns the string representation of the present DerivedCredentials object.
     *
     * @return a string representation of the present object.
     *****************************************************************************************************************/
    @Override
    public String toString() {
        return "DerivedCredentials {" +
                "Private Key: " + privateKey +
                ", Public Key: " + publicKey +
                ", Public Address: '" + publicAddress + '\'' +
                '}';
    }

    /******************************************************************************************************************
     * Method that returns a JSON representation of the present DerivedCredentials object.
     *
     * @return a JSON representation of the present object.
     *****************************************************************************************************************/
    public String toJSON() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }
}
