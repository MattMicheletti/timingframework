/**
 * Copyright (c) 2006, Sun Microsystems, Inc
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 *   * Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above
 *     copyright notice, this list of conditions and the following 
 *     disclaimer in the documentation and/or other materials provided 
 *     with the distribution.
 *   * Neither the name of the TimingFramework project nor the names of its
 *     contributors may be used to endorse or promote products derived 
 *     from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.jdesktop.animation.timing.triggers;

import org.jdesktop.animation.timing.*;
import org.jdesktop.animation.timing.triggers.Trigger.TriggerAction;
import org.jdesktop.animation.timing.triggers.TriggerEvent;


/**
 * Abstract superclass of all listeners for triggers.  This class caches the
 * timer and action to be performed on the trigger and implements the utility
 * method pullTrigger() that is called by subclasses upon a valid trigger
 * event.
 *
 * @author Chet
 */
public abstract class TriggerListener {
    TimingController timer;
    TriggerAction action;
    protected TriggerListener(TimingController timer, TriggerAction action) {
        this.timer = timer;
        this.action = action;
    }
    
    /**
     * Utility method to start or stop the timer based on the specified
     * TriggerAction that the listener was created with
     */
    protected void pullTrigger() {
        if (action == TriggerAction.START) {
            timer.start();
        } else {
            timer.stop();
        }
    }
}