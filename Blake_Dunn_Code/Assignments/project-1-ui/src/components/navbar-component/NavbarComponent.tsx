import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Navbar, NavbarBrand, NavbarToggler, Collapse, Nav, NavItem, NavLink, UncontrolledDropdown, DropdownToggle, DropdownMenu, DropdownItem, NavbarText } from 'reactstrap';


export const NavbarComponent = (props: any) => {
    const [isOpen, setisOpen] = useState(false);

    const toggle = () => setisOpen(!isOpen);

    return (
        <div>
            <Navbar color="light" light expand="md">
                <NavbarBrand href="/">Buhlakay UI</NavbarBrand>
                <NavbarToggler onClick={toggle} />
                <Collapse isOpen={isOpen} navbar>
                    <Nav className="mr-auto" navbar>
                        <NavItem>
                            <NavLink to='/login'>Login</NavLink>
                        </NavItem>
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
                    <NavbarText>Buhlakay UI is the Best</NavbarText>
                </Collapse>
            </Navbar>
        </div>
    )
}