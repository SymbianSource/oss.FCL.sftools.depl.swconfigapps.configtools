/*
 * Copyright (c) 2009 Nokia Corporation and/or its subsidiary(-ies).
 * All rights reserved.
 * This component and the accompanying materials are made available
 * under the terms of "Eclipse Public License v1.0"
 * which accompanies this distribution, and is available
 * at the URL "http://www.eclipse.org/legal/epl-v10.html".
 * 
 * Initial Contributors:
 * Nokia Corporation - Initial contribution
 * 
 * Contributors:
 * 
 * Description: This file is part of com.nokia.tools.vct.common.appmodel component.
 */

package com.nokia.tools.vct.common.appmodel.util;

import java.security.PrivateKey;
import java.security.cert.X509Certificate;

/**
 * Public interface for accessing encrypted content.
 * <p>
 * The interface enables read and write operations. Depending on the
 * initialization scenario, it can be ready for both operations, or only for
 * write operation. In latter case it still can be used for reading written
 * data.
 */
public interface ISecureCPFContentProvider extends ICPFContentProvider {

	/** Default block encryption algorithm (AES) */
	String DEFAULT_BLOCK_ALGORITHM = "AES";
	/** Default block encryption key size (128) */
	int DEFAULT_KEY_SIZE = 128;

	/**
	 * Get array of authorized users' certificates
	 * 
	 * @return Array of X.509 certificates
	 */
	X509Certificate[] getUserCertificates();

	/**
	 * Change list of authorized user's
	 * 
	 * @param certificates
	 *            New set of certificates
	 */
	void setUserCertificates(X509Certificate... certificates);

	/**
	 * Get certificate of the user who has signed CPF header.
	 * 
	 * @return X.509 certificate
	 */
	X509Certificate getAuthorCertificate();

	/**
	 * Get certificate of the user who has signed CPF header.
	 * 
	 * @return X.509 certificate
	 */
	X509Certificate getReaderCertificate();

	/**
	 * Set the author's certificate
	 * 
	 * @param certificate
	 *            X.509 certificate
	 */
	void setAuthorCertificate(X509Certificate certificate);

	/**
	 * Get block cipher algorithm
	 * 
	 * @return Algorithm string
	 */
	String getBlockAlgorithm();

	/**
	 * Set block cipher algorithm
	 * 
	 * @param algorithm
	 *            Algorithm string
	 */
	void setBlockAlgorithm(String algorithm);

	/**
	 * Get block cipher key size
	 * 
	 * @return Key size
	 */
	int getKeySize();

	/**
	 * Set block cipher key size
	 * 
	 * @param size
	 *            Size of the key
	 */
	void setKeySize(int size);

	/**
	 * Get private key of the current user
	 * 
	 * @return RSA Private key
	 */
	PrivateKey getPrivateKey();

	/**
	 * Set private key of the current user
	 * 
	 * @param privateKey
	 *            RSA Private key
	 */
	void setPrivateKey(PrivateKey privateKey);
}
