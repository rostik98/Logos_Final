package ua.lviv.lgs.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ua.lviv.lgs.domain.Entrant;

public class CustomUserDetails extends Entrant implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// private List<String> entrantRoles;

	public CustomUserDetails(Entrant entrant) {
		super(entrant);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// String roles = StringUtils.collectionToCommaDelimitedString(userRoles);
		// return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
		return null;
	}
//
//	public Integer getUserID() {
//		return super.getId();
//	}

	@Override
	public String getUsername() {
		return super.getFirstName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
