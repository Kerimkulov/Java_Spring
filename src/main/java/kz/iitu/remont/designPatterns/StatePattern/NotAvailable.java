package kz.iitu.remont.designPatterns.StatePattern;

import kz.iitu.remont.entities.Reapirier;

public class NotAvailable implements ReparierStates{
    @Override
    public void AvailableRep(Reapirier r) {
        r.setPs(new Available());
    }

    @Override
    public void NotAvailableRep(Reapirier r) {
        System.out.println("Repariers is already not available");
    }
}
