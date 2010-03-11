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

import org.eclipse.core.runtime.CoreException;

import com.nokia.tools.vct.internal.common.appmodel.util.SecureCPFContentProvider;

/**
 * Utilities for encryption operations. The main user operations are:
 * <ul>
 * <li>{@link #createSecureContentProvider(Object, X509Certificate, PrivateKey)}
 * - Creating input provider
 * <li>
 * {@link #createSecureContentProvider(Object, String, int, X509Certificate, PrivateKey, X509Certificate[])}
 * - Creating output provider
 * </ul>
 */
public class CPFEncryptionUtils {


	/**
	 * Creates content provider for reading and writing and initializes
	 * information from the source.
	 * 
	 * @param input
	 *            Source object.
	 * @param userCertificate
	 *            Certificate of the user, who tries to access the content, or
	 *            <code>null</code>
	 * @param privateKey
	 *            Private key of the user, who tries to access the content, or
	 *            <code>null</code>
	 * @return If the user's certificate and private key are provided, then the
	 *         returned object is fully initialized, otherwise it contains
	 *         information read from the header.
	 * @throws CoreException
	 *             On error. The <code>cause</code> field of the status contain
	 *             the reason of failure. In case of unauthorized access,
	 *             {@link SecurityException} is there.
	 */
	public static ISecureCPFContentProvider createSecureContentProvider(
			Object input, X509Certificate userCertificate, PrivateKey privateKey)
			throws CoreException {
		ICPFContentProvider filter = CPFUtil.selectCPFContentProvider(input);
		SecureCPFContentProvider result = new SecureCPFContentProvider(filter);
		result.initializeFromSource(userCertificate, privateKey);
		return result;
	}

	/**
	 * Creates content provider suitable for writing data.
	 * 
	 * @param output
	 *            Output object
	 * @param algorithm
	 *            Algorithm to use.
	 * @param keySize
	 *            Key size
	 * @param userCertificate
	 *            User's certificate
	 * @param privateKey
	 *            User's private key
	 * @param users
	 *            Authorized user list
	 * @return Object initialized for output.
	 */
	public static ISecureCPFContentProvider createSecureContentProvider(
			Object output, String algorithm, int keySize,
			X509Certificate userCertificate, PrivateKey privateKey,
			X509Certificate[] users) {
		ICPFContentProvider filter = CPFUtil.selectCPFContentProvider(output);
		SecureCPFContentProvider result = new SecureCPFContentProvider(filter);
		result.setAuthorCertificate(userCertificate);
		result.setReaderCertificate(userCertificate);
		result.setPrivateKey(privateKey);
		result.setBlockAlgorithm(algorithm);
		result.setKeySize(keySize);
		result.setUserCertificates(users);
		return result;
	}

}
