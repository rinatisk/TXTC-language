// This is a generated file. Not intended for manual editing.
package com.github.rinatisk.txtclanguage.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.rinatisk.txtclanguage.language.psi.TxtcTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.sdk.language.com.github.rinatisk.txtclanguage.language.psi.*;

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
