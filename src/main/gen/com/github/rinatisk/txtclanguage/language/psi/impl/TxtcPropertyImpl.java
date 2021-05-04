// This is a generated file. Not intended for manual editing.
package com.github.rinatisk.txtclanguage.language.psi.impl;

import java.util.List;

import com.github.rinatisk.txtclanguage.language.psi.TxtcProperty;
import com.github.rinatisk.txtclanguage.language.psi.TxtcVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;

public class TxtcPropertyImpl extends ASTWrapperPsiElement implements TxtcProperty {

  public TxtcPropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TxtcVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TxtcVisitor) accept((TxtcVisitor)visitor);
    else super.accept(visitor);
  }

}
