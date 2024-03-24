package org.jsp.merchantproductapp.controller;

import java.util.Scanner;

import org.jsp.merchantproduct.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class MerchantController {
	public static void main(String[] args) {
		MerchantDao merchantDao = new MerchantDao();
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Save Merchant");
		System.out.println("2.Update merchant");
		System.out.println("3.Find Merchant By Id");
		System.out.println("4.Verify Merchant By Phone and password");
		System.out.println("5.Verify Merchant By Email and password");
		switch (sc.nextInt()) {
		case 1: {
			Merchant merchant = new Merchant();
			System.out.println("Enter the name,phone,email, gst_number and password to save Merchant");
			merchant.setName(sc.next());
			merchant.setPhone(sc.nextLong());
			merchant.setEmail(sc.next());
			merchant.setGst_number(sc.next());
			merchant.setPassword(sc.next());
			merchant = merchantDao.saveMerchant(merchant);
			System.out.println("Merchant Saved with id:" + merchant.getId());
			break;
		}
		case 2: {
			Merchant merchant = new Merchant();
			System.out.println("Enter the id name,phone,email, gst_number and password to update Merchant");
			merchant.setId(sc.nextInt());
			merchant.setName(sc.next());
			merchant.setPhone(sc.nextLong());
			merchant.setEmail(sc.next());
			merchant.setGst_number(sc.next());
			merchant.setPassword(sc.next());
			merchant = merchantDao.updateMerchant(merchant);
			if (merchant != null)
				System.out.println("Merchant  with id:" + merchant.getId() + " updated");
			else
				System.err.println("Cannot Update Merchant as Id is Invalid");
			break;
		}
		case 3: {
			System.out.println("Enter the Merchant Id to display details");
			int merchant_id = sc.nextInt();
			Merchant merchant = merchantDao.findMerchantById(merchant_id);
			if (merchant != null)
				System.out.println(merchant);
			else
				System.err.println("Invalid merchant Id");
			break;
		}
		case 4: {
			System.out.println("Enter the Phone Number and Password to verify Merchant");
			long phone = sc.nextLong();
			String password = sc.next();
			Merchant merchant = merchantDao.verifyMerchant(phone, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Phone Number or Password");
			}
			break;
		}
		case 5: {
			System.out.println("Enter the Email Id and Password to verify Merchant");
			String email = sc.next();
			String password = sc.next();
			Merchant merchant = merchantDao.verifyMerchant(email, password);
			if (merchant != null) {
				System.out.println(merchant);
			} else {
				System.err.println("Invalid Email Id or Password");
			}
			break;
		}
		default: {
			sc.close();
			System.err.println("Invalid Choice");
		}
		}
	}
}
