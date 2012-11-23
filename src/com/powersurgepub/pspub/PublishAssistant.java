package com.powersurgepub.pspub;

  import java.io.*;

/**
 An interface for a class that assists in publishing data via PublishWindow.
 
 @author Herb Bowie
 */
public interface PublishAssistant {

  /**
   Prepare data to be used in the publishing process by PublishWindow.

   @param publishTo The folder to which we are publishing.
   */
  public void prePub(File publishTo);

  /**
   Perform a publishing operation when requested by the publishing script.

   @param publishTo The folder to which we are publishing.
   @param operand An operand specifying the operation to
                  be performed.
   */
  public boolean pubOperation(File publishTo, String operand);

  /**
   Any post-processing to be done after PublishWindow has completed its
   publication process.

   @param publishTo The folder to which we are publishing. 
   */
  public void postPub(File publishTo);

}
