package io.github.zodh.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractValidator<T> {

    private AbstractValidator<T> nextValidator;
    private List<T> itemsToValidate;
    private List<ErrorMessage> errorMessages = new ArrayList<>();



    public void includeItemsToValidate(List<T> items) {
        items.forEach(this::includeItemToValidate);
    }

    public void includeItemToValidate(T item) {
        if (itemsToValidate == null)
            itemsToValidate = new ArrayList<>();
        this.itemsToValidate.add(item);
    }

    public void includeErrorMessage(String message, String reason, String location) {
        if (this.errorMessages == null)
            this.errorMessages = new ArrayList<>();
        this.errorMessages.add(new ErrorMessage(message, reason, location));
    }

    public void includeErrorMessage(ErrorMessage errorMessage) {
        if (errorMessage == null)
            return;
        if (this.errorMessages == null)
            this.errorMessages = new ArrayList<>();
        this.errorMessages.add(errorMessage);
    }

    public boolean hasInvalidItems() {
        return !this.errorMessages.isEmpty();
    }

    public void validate() {
        this.applyValidations(itemsToValidate);
        Optional.ofNullable(this.nextValidator).ifPresent(av -> {
            av.attachErrorMessages(this.errorMessages);
            av.setItemsToValidate(this.itemsToValidate);
            av.validate();
        });
    }

    /**
     * This method must validate the existing items in itemsToValidate and add the errors found in errorMessages.
     *
     * @param itemsToValidate loads the items to be validated.
     */
    protected abstract void applyValidations(List<T> itemsToValidate);

    public void attachNextValidator(AbstractValidator<T> nextValidator) {
        this.nextValidator = nextValidator;
    }

    public void attachErrorMessages(List<ErrorMessage> existingErrors) {
        if (errorMessages == null)
            errorMessages = new ArrayList<>();
        this.errorMessages.addAll(existingErrors);
    }

    public void check(RuntimeException ex) {
        if (hasInvalidItems())
            throw ex;
    }

    public void setItemsToValidate(List<T> itemsToValidate) {
        this.itemsToValidate = itemsToValidate;
    }

    public List<ErrorMessage> getErrorMessages() {
        return errorMessages;
    }
}
