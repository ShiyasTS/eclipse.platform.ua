/*
 * (c) Copyright IBM Corp. 2000, 2001.
 * All Rights Reserved.
 */
package org.eclipse.help;
/**
 * Interface to the help system UI.
 * <p>
 * The Eclipse platform defines an extension point 
 * (<code>"org.eclipse.help.support"</code>) for plugging in a help system UI.
 * The help system UI is entirely optional.
 * Clients may provide a UI for presenting help to the user by implementing this
 * interface and including the name of their class in the 
 * <code>&LT;config&GT;</code> element in an extension to the platform's help 
 * support extension point (<code>"org.eclipse.help.support"</code>).
 * </p>
 * <p>
 * Note that an implementation of the help system UI is provided by the 
 * <code>"org.eclipse.help.ui"</code> plug-in (This plug-in is not 
 * mandatory, and can be removed). Since the platform can only make use of a 
 * single help system UI implementation, make sure that the platform is not 
 * configured with more than one plug-in trying to extend this extension point.
 * </p>
 * <p>
 * <b>Note:</b> This class/interface is part of an interim API that is still under development and expected to
 * change significantly before reaching stability. It is being made available at this early stage to solicit feedback
 * from pioneering adopters on the understanding that any code that uses this API will almost certainly be broken
 * (repeatedly) as the API evolves.
 * </p>
 */
public interface IHelp {
	/**
	 * Displays context-sensitive help for contexts with the given context ids.
	 * <p>
	 * (x,y) coordinates specify the location where the context sensitive
	 * help UI will be presented. These coordinates are screen-relative 
	 * (ie: (0,0) is the top left-most screen corner).
	 * The platform is responsible for calling this method and supplying the 
	 * appropriate location.
	 * </p> 
	 * 
	 * @param contextIds a list of help context ids
	 * @param x horizontal position
	 * @param y verifical position
	 * @see #findContext
	 */
	public void displayHelp(String[] contextIds, int x, int y);
	/**
	 * Displays context-sensitive help for the given contexts.
	 * <p>
	 * (x,y) coordinates specify the location where the context sensitive 
	 * help UI will be presented. These coordinates are screen-relative 
	 * (ie: (0,0) is the top left-most screen corner).
	 * The platform is responsible for calling this method and supplying the 
	 * appropriate location.
	 * </p>
	 * 
	 * 
	 * @param contexts a list of help contexts
	 * @param x horizontal position
	 * @param y verifical position
	 */
	public void displayHelp(IContext[] contexts, int x, int y);
	/**
	 * Displays help content for the toc with the given URL.
	 * <p>
	 * This method is called by the platform to launch the help system UI, displaying
	 * the documentation identified by the <code>toc</code> parameter.
	 * </p> 
	 * <p>
	 * Valid toc are
	 * contributed through the <code>toc</code> element of the 
	 * <code>"org.eclipse.help.toc"</code> extension point.   
	 * </p> 
	 *
	 * @param toc the URL of the toc as specified in
	 * the <code>"org.eclipse.help.toc"</code> extenstion
	 * point
	 */
	public void displayHelp(String toc);
	/**
	 * This method is an extension to the 
	 * <a href="#displayHelp(java.lang.String)">displayHelp(String toc)</a>
	 * method, providing the ability to open the specified help topic.
	 * <p>
	 * <code>selectedTopic</code> should be a valid help topic url contained in
	 * the specified <code>toc</code> and have the following format: 
	 * <em>/pluginID/path_to_document</em>
	 * <br>where
	 * <dl>
	 * <dt> <em>pluginID</em> is the unique identifier of the plugin containing the help topic, 
	 * </dt>
	 * <dt> <em>path_to_document</em> is the help topic path, relative to the plugin directory
	 * </dt>
	 * </dl>
	 * </p>
	 * @param toc the URL of the toc
	 * @param selectedTopic the help topic url.
	 * @see #displayHelp(java.lang.String)
	 */
	public void displayHelp(String toc, String selectedTopic);
	/**
	 * Computes and returns context information for the given context id.
	 * 
	 * @param contextId the context id
	 * @return the context, or <code>null</code> if none
	 */
	public IContext findContext(String contextId);
}