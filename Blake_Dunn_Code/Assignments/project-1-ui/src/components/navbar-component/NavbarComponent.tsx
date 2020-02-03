import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, NavbarBrand, NavbarToggler, Collapse, Nav, NavItem, NavLink, UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem, NavbarText } from 'reactstrap';


export const NavbarComponent = (props: any) => {
    const [isOpen, setisOpen] = useState(false);

    const toggle = () => setisOpen(!isOpen);

    return (
        <div>
            <Navbar color="light" light expand="md">
                <NavbarBrand href="/">Buhlakify EM</NavbarBrand>
                <NavbarToggler onClick={toggle} />
                <Collapse isOpen={isOpen} navbar>
                    <Nav className="mr-auto" navbar>
                        <UncontrolledDropdown nav inNavbar>
                            <DropdownToggle nav caret>
                                Sign-In
                            </DropdownToggle>
                            <DropdownMenu center>
                                <DropdownItem>
                                    <Link to='/login'>Login</Link>
                                </DropdownItem>
                                <DropdownItem>
                                    <Link to='/register'>Register</Link>
                                </DropdownItem>
                            </DropdownMenu>
                            </UncontrolledDropdown>
                            <NavItem>
                                <NavLink href="https://github.com/wsingleton/191216-react-combo">GitHub</NavLink>
                            </NavItem>
                            <UncontrolledDropdown nav inNavbar>
                                <DropdownToggle nav caret>
                                    Links
                                </DropdownToggle>
                                <DropdownMenu right>
                                    <DropdownItem>

                                    </DropdownItem>
                                    <DropdownItem>

                                    </DropdownItem>
                                </DropdownMenu>
                            </UncontrolledDropdown>
                    </Nav>
                        <NavbarText>Buhlakify is the Best</NavbarText>
                </Collapse>
            </Navbar>
        </div>
            )
}