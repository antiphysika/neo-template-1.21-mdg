package antiphysika.template.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

import static antiphysika.template.TemplateMod.MOD_ID;

public class ModTranslations extends LanguageProvider
{
  public ModTranslations(PackOutput output, String locale)
  {
    super(output, MOD_ID, locale);
  }

  @Override
  protected void addTranslations()
  {
    add("block.template.example_block", "Example Block");
  }
}

//
// vim: ts=2 sw=2 et fdm=marker :