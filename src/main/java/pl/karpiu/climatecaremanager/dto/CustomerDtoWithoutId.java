package pl.karpiu.climatecaremanager.dto;

public record CustomerDtoWithoutId(String firstName,
        String lastName,
        String address,
        String city,
        String phoneNumber,
        String email) {
}
