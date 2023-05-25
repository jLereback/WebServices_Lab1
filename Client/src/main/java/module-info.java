import se.iths.service.StringCalculator;
import se.iths.service.annotation.Calculate;

module Client {
    requires TextService;
    uses StringCalculator;
    uses Calculate;
}
