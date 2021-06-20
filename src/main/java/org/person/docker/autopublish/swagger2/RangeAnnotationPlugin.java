package org.person.docker.autopublish.swagger2;

import static springfox.bean.validators.plugins.Validators.annotationFromBean;

import java.math.BigDecimal;
import java.util.Optional;
import javax.validation.constraints.Email;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import springfox.bean.validators.plugins.Validators;
import springfox.documentation.builders.StringElementFacetBuilder;
import springfox.documentation.schema.NumericElementFacetBuilder;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;
import org.hibernate.validator.constraints.Range;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class RangeAnnotationPlugin implements ModelPropertyBuilderPlugin {

  @Override
  public boolean supports(DocumentationType delimiter) {
    return true;
  }

  @Override
  public void apply(ModelPropertyContext context) {
    Optional<Range> range = annotationFromBean(context, Range.class);
    if (range.isPresent()) {
      context.getSpecificationBuilder().facetBuilder(NumericElementFacetBuilder.class).maximum(BigDecimal.valueOf(range.get().max())).minimum(BigDecimal.valueOf(range.get().min()));
      context.getSpecificationBuilder().example(BigDecimal.valueOf((range.get().max() + range.get().min()) / 2));
    }
  }
}