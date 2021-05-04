// This is a generated file. Not intended for manual editing.
package com.github.rinatisk.txtclanguage.language.psi;

import com.github.rinatisk.txtclanguage.language.psi.impl.TxtcPropertyImpl;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;

public interface TxtcTypes {

  IElementType PROPERTY = new TxtcElementType("PROPERTY");

  IElementType VALUE = new TxtcTokenType("VALUE");
  IElementType WHITE_SPACES = new TxtcTokenType("WHITE_SPACES");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new TxtcPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
