package lv.rtu.vladkoto.test;

import java.util.Date;
import java.util.Random;

import lv.rtu.vladkoto.account.pojo.AccountPojo;
import lv.rtu.vladkoto.account.pojo.AccountPojoHome;
import lv.rtu.vladkoto.account.pojo.ProductPojo;
import lv.rtu.vladkoto.account.pojo.ProductPojoHome;
import lv.rtu.vladkoto.party.pojo.PartyPojo;
import lv.rtu.vladkoto.party.pojo.PartyPojoHome;
import static java.lang.System.out;

public class App {

	final static Random rnd = new Random(System.currentTimeMillis());

	public static ProductPojo registerNewProduct() {
		ProductPojoHome productHome = new ProductPojoHome();
		ProductPojo product = new ProductPojo(rnd.nextInt(100), 1,
				"Test product", new Date(), null);
		productHome.merge(product);
		product = (ProductPojo) productHome.findByExample(product).get(0);
		return product;
	}

	public static AccountPojo registerNewAccount(ProductPojo product,
			PartyPojo party) {
		AccountPojoHome accountHome = new AccountPojoHome();
		AccountPojo account = new AccountPojo(rnd.nextInt(100), "0001",
				new Date(), new Date(), "OPEN", 0.0, party, product, null);
		accountHome.merge(account);
		account = (AccountPojo) accountHome.findByExample(account).get(0);

		return account;
	}

	public static PartyPojo registerNewParty() {
		PartyPojoHome partyHome = new PartyPojoHome();
		PartyPojo party = new PartyPojo(rnd.nextInt(100), "vladkoto",
				"120283-10210", "ACTIVE", new Date(), null, null, null);
		partyHome.merge(party);
		party = (PartyPojo) partyHome.findByExample(party).get(0);
		return party;
	}

	public static void main(String[] args) {
		System.out.print("Registering new product ...");
		ProductPojo product = registerNewProduct();
		System.out.println("OK");
		System.out.print("Registering new party ...");
		PartyPojo party = registerNewParty();
		System.out.println("OK");
		System.out.print("Registering new party account...");
		AccountPojo account = registerNewAccount(product, party);
		System.out.println("DONE");
	}

}
